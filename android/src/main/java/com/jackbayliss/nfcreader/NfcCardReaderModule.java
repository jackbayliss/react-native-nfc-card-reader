package com.jackbayliss.nfcreader;

import android.content.Intent;
import android.app.Activity;
import android.nfc.NfcAdapter;
import android.util.Log;

import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Arguments;


public class NfcCardReaderModule extends ReactContextBaseJavaModule implements ActivityEventListener {

    private static final String TAG = "NfcCardReaderActivity";
    private static final int INTENT = 900;
    private final ReactApplicationContext reactContext;

    private Callback mNfcCallback = null;

    public NfcCardReaderModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        this.reactContext.addActivityEventListener(this);

    }

    @Override
    public String getName() {
        return "NfcCardReader";
    }

    @ReactMethod
    public void startNfc(Callback callback) {
    mNfcCallback = callback;
    Activity activity = getCurrentActivity();
    Intent scanIntent = new Intent(activity,NfcCardReaderActivity.class);
    if (activity != null) {
        activity.startActivityForResult(scanIntent, INTENT);
    }
    
	}

    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent intent) {
       if(intent!=null && intent.hasExtra("cardNumber") && intent.hasExtra("expiryDate") && intent.hasExtra("cardType")){
            if (requestCode==INTENT && activity.RESULT_OK==resultCode) {
                        WritableMap NfcCardDetails = Arguments.createMap();
                        String cardNumber = intent.getExtras().getString("cardNumber");
                        String expiryDate = intent.getExtras().getString("expiryDate");
                        String cardType = intent.getExtras().getString("cardType");  
                        NfcCardDetails.putString("cardNumber", cardNumber);
                        NfcCardDetails.putString("expiryDate", expiryDate);
                        NfcCardDetails.putString("cardType", cardType);
                        mNfcCallback.invoke(NfcCardDetails);
                    }
       }
      
    }

  public void onNewIntent(Intent intent) {
   
    }
  }