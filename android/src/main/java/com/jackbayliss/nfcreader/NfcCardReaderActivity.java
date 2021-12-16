package com.jackbayliss.nfcreader;

import android.os.Bundle;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.app.Activity;
import android.widget.Toast;

import com.pro100svitlo.creditCardNfcReader.CardNfcAsyncTask;
import com.pro100svitlo.creditCardNfcReader.utils.CardNfcUtils;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableNativeArray;
import android.util.Log;
public class NfcCardReaderActivity extends ReactActivity implements CardNfcAsyncTask.CardNfcInterface {

    private static final String TAG = "NfcCardReaderActivity";
    private CardNfcAsyncTask mCardNfcAsyncTask;
    private CardNfcUtils mCardNfcUtils;
    private NfcAdapter mNfcAdapter;
    private boolean mIntentFromCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        setContentView(R.layout.nfcview);
        if (mNfcAdapter == null){
            //do something if there are no nfc module on device
        } else {
            //do something if there are nfc module on device
            mCardNfcUtils = new CardNfcUtils(this);
            mIntentFromCreate = true;
            onNewIntent(getIntent());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIntentFromCreate = false;
        if (mNfcAdapter != null && !mNfcAdapter.isEnabled()){
        
          
        } else if (mNfcAdapter != null){
            mCardNfcUtils.enableDispatch();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mNfcAdapter != null) {
            mCardNfcUtils.disableDispatch();
        }
    }
    @Override
    public void onNewIntent(Intent intent) {
        setIntent(intent);
        super.onNewIntent(intent);
        if (mNfcAdapter != null && mNfcAdapter.isEnabled()) {
        
            mCardNfcAsyncTask = new CardNfcAsyncTask.Builder(this, intent, mIntentFromCreate)
                    .build();
        }

}

@Override
public void finishNfcReadCard() {
    mCardNfcAsyncTask = null;
}
@Override
public void cardWithLockedNfc() {
    Toast.makeText(this, "This card is locked!", Toast.LENGTH_SHORT).show();
}
@Override
public void unknownEmvCard() {
    Toast.makeText(this, "This is an unknown card!", Toast.LENGTH_SHORT).show();
}
@Override
public void doNotMoveCardSoFast() {
    Toast.makeText(this, "Don't move the card so quickly!", Toast.LENGTH_SHORT).show();

}

@Override
public void cardIsReadyToRead() {
    Toast.makeText(this, "Your card was read!", Toast.LENGTH_SHORT).show();
    String card = mCardNfcAsyncTask.getCardNumber();
    String expiryDate = mCardNfcAsyncTask.getCardExpireDate();
    String cardType = mCardNfcAsyncTask.getCardType();
    String firstName = mCardNfcAsyncTask.getHolderFirstname();
    String lastName = mCardNfcAsyncTask.getHolderLastname();

    Intent intent = new Intent();
    intent.putExtra("cardNumber", card);
    intent.putExtra("expiryDate", expiryDate);
    intent.putExtra("cardType", cardType);  
    intent.putExtra("firstName", firstName);  
    intent.putExtra("lastName", lastName);  

    setResult(RESULT_OK, intent);
    finish();
   
    

}

@Override
public void startNfcReadCard() {
    Toast.makeText(this, "NFC is scanning...", Toast.LENGTH_SHORT).show();

}




}