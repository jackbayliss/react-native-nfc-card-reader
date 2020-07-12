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

## Methods
 `startNfc(callback)` -> Will start the NFC Activity and will callback with the card details it's scanned.


 # License
 MIT