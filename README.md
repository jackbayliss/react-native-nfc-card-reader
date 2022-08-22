# react-native-nfc-card-reader

## Description 
This package is specifically designed to scan credit/debit cards using an Android devices NFC reader and return the card number, expiry and card type.

This package will only work on Android and isn't available for iOS as of 2020  because Apple do not allow 3rd party iPhone apps to use the Core NFC framework.
## Getting started

`$ npm install react-native-nfc-card-reader --save`
### For Gradle 7.0 and < 7.2 you can do:
`npm install "https://github.com/jackbayliss/react-native-nfc-card-reader.git#gradle7.0" --save`

### For Gradle 7.2 you can do:
`npm install "https://github.com/jackbayliss/react-native-nfc-card-reader.git#gradle7.2" --save`

### Mostly automatic installation

`$ react-native link react-native-nfc-card-reader`

## Usage
```javascript
import NfcCardReader from 'react-native-nfc-card-reader';

NfcCardReader.startNfc(function(cardDetails){
     // Card details contain the callback data below, see the options.
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

`firstName` -> Card owners first name.

`lastName` -> Card owners last name.

### Example App
You can find the sample app [here](https://github.com/jackbayliss/react-native-nfc-card-reader-sample)

# Contributing
I am by no means an Android developer, but saw this as a huge thing no one had produced for React Native. So, if you can expand or improve on my basic implementation feel free to create a pull request. 


 # License
 MIT - expanded from [here](https://github.com/pro100svitlo/Credit-Card-NFC-Reader)
 
 
 A special thanks to [pro100svitlo](https://github.com/pro100svitlo/Credit-Card-NFC-Reader) for their library which gave me the ability to create this module.
 A special thanks to [decoder10](https://github.com/decoder10) for fixing a few issues, and adding firstname / lastname - as well as allowing any NFC cards to be scanned.

 
