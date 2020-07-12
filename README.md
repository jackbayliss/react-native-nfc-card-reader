# react-native-nfc-card-reader

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
 `startNfc(callback)` -> Will start the NFC Activity and will callback with the card details it's scanned.
     
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
 
 
