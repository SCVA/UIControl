package ejemplo.uicontrol;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textoprueba;
    private Button botonColor;
    private ImageButton botonImagen;
    private EditText textoEntrada;
    private CheckBox deshabilitarBotn;
    private Switch switchePrueba;
    private RadioGroup dimensionLetra;
    private Spinner selector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        textoprueba = (TextView) findViewById( R.id.texto );
        botonColor = (Button) findViewById( R.id.button2 );
        botonColor.setOnClickListener( this );
        botonImagen = (ImageButton) findViewById( R.id.imageButton );
        botonImagen.setOnClickListener( this );
        textoEntrada = (EditText) findViewById( R.id.editText );

        textoEntrada.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                textoprueba.setText( textoEntrada.getText() );
            }
        } );

        deshabilitarBotn = (CheckBox) findViewById( R.id.deshabilitarBoton );
        deshabilitarBotn.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(deshabilitarBotn.isChecked()){
                    botonImagen.setEnabled( false );
                }else{
                    botonImagen.setEnabled( true );
                }
            }
        } );

        switchePrueba = (Switch) findViewById( R.id.switch1 );
        switchePrueba.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(switchePrueba.isChecked()){
                    botonColor.setEnabled( false );
                }else{
                    botonColor.setEnabled( true );
                }
            }
        } );

        dimensionLetra = (RadioGroup) findViewById( R.id.dimensionLetra );
        dimensionLetra.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radioButtonNormal:
                        textoprueba.setTextSize( 1,24 );
                        break;
                    case R.id.radioButtonMediano:
                        textoprueba.setTextSize( 1,35 );
                        break;
                    case R.id.radioButtonGrande:
                        textoprueba.setTextSize( 1,50 );
                        break;
                }
            }
        } );

        selector = (Spinner) findViewById( R.id.spinner );
        selector.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String opcionSeleccionada = adapterView.getItemAtPosition( i ).toString();
                if (opcionSeleccionada.equals( "Home" )) {
                    textoprueba.setText( "Casa" );
                }else{
                    textoprueba.setText( "Sin dato" );
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );
    }

    public void accionarBoton(View v){
        textoprueba.setTextSize( 1,50 );
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.button2:
                textoprueba.setTextColor( Color.parseColor("#80CBC4") );
                break;
            case R.id.imageButton:
                textoprueba.setTextSize( 1,10 );
                break;
        }
    }

}