package siddharth.com.chemforwear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends Activity {

    String spokenText;
    Element x;
    private ArrayList<Element> elements;
    Scanner scn = null;
    private static final int SPEECH_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elements = new ArrayList<Element>();
        processArrayList(elements);

        Button searchButton = (Button) findViewById(R.id.button_search);
        Button listButton = (Button) findViewById(R.id.button_list);

        searchButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                displaySpeechRecognizer();
            }
        });

        listButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                displayList();
            }
        });

        elements = new ArrayList<Element>();
        processArrayList(elements);


    }

    public void processText(){

        x = getElementBySymbol(spokenText);

        if(x == null){
            System.out.println("Failed");
            //System.exit(0);
        } else {
            showInfoView();
        }


    }

    public void showInfoView(){
        Intent intent = new Intent(MainActivity.this, InfoActivity.class);
        intent.putExtra("EXTRA_ELEMENT", x);
        startActivity(intent);

    }

    public void displayList(){}
    // Create an intent that can start the Speech Recognizer activity

    private void displaySpeechRecognizer() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        // Start the activity, the intent will be populated with the speech text
        startActivityForResult(intent, SPEECH_REQUEST_CODE);
    }

    // This callback is invoked when the Speech Recognizer returns.
    // This is where you process the intent and extract the speech text from the intent.
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(
                RecognizerIntent.EXTRA_RESULTS);
                spokenText = results.get(0);
                // Do something with spokenText
                processText();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    public void processArrayList(ArrayList<Element> list)
    {
        try{
            scn = new Scanner(getResources().openRawResource(R.raw.periodictable));

            while(scn.hasNext()) {
                list.add(new Element(scn.nextInt(), scn.next(), scn.next(), "Pseudo-Info"));
            }

            scn.close();

        } catch (Exception e){
            e.printStackTrace();
            System.out.print("Action Failed.");

        }

        System.out.println(list);



    }

    /*public Element getElementByNumber(int atomicNumber)
    {
        for(int i = 0; i < elements.size(); i++){
            if(elements.get(i).getAtomicNumber() == (atomicNumber)){
                return elements.get(i);
            }
        }
        return null;
    }*/

    public Element getElementBySymbol(String symbol)
    {
        for(int i = 0; i < elements.size(); i++){
            if(elements.get(i).getSymbol().equalsIgnoreCase(symbol)){
                return elements.get(i);
            }
        }

        return null;


    }
}
