# react-native-nfc-card-reader

## Description 
This package is specifically designed to scan credit/debit cards using an Android devices NFC reader and return the card number, expiry and card type.

This package will only work on Android and isn't available for iOS as of 2020  because Apple do not allow 3rd party iPhone apps to use the Core NFC framework.
## Getting started

`$ npm install react-native-nfc-card-reader --save`

### Mostly automatic installation

`$ react-native link react-native-nfc-card-reader`

## Usage
```javascript
import NfcCardReader from 'react-native-nfc-card-reader';

NfcCardReader.startNfc(function(cardDetails){
     that.setState({cardNumber : cardDetails.cardNumber})
     that.setState({expiryDate : cardDetails.expiryDate})
     that.setState({cardType : cardDetails.cardType})

    })
```
Ensure you add the following to your `AndroidManifest.xml` located in `android\app\src\main`
```
<activity android:name="com.jackbayliss.nfcreader.NfcCardReaderActivity"/>
```
## Methods
 `startNfc(callback)` -> Will start the NFC Activity and expects a callback function that will return the card details it's scanned.
     
### Callback data
`cardType` -> Provides the type of the card scanned.

`cardNumber` -> Provides the full card number scanned.

`expiryDate` -> Providers the expiry date of the card scanned.

### Example App
You can find the sample app [here](https://github.com/jackbayliss/react-native-nfc-card-reader-sample)

# Contributing
I am by no means an Android developer, but saw this as a huge thing no one had produced for React Native. So, if you can expand or improve on my basic implementation feel free to create a pull request. 


 # License
 MIT - expanded from [here](https://github.com/pro100svitlo/Credit-Card-NFC-Reader)
 
 
 A special thanks to [pro100svitlo](https://github.com/pro100svitlo/Credit-Card-NFC-Reader) for their library which gave me the ability to create this module.
 
 
