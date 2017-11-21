

# Smart Block

This tutorial is meant for those with a basic knowledge of Ethereum and smart contracts, who have some knowledge of Java, Android Studio and some basic programming knowledge but who are new to dApps.

# What we'll do

- Setting up the development environment.
- Set up solidity and web3j.


# How to setup

Clone the project using ``git clone https://github.com/imraniot/digitalshop.git``

Install NodeJS (includes NPM 5.5.1) from here https://nodejs.org/en/download/

Open terminal and run  `` npm -g install solc``
 
Download **web3j** from here as per for OC version https://github.com/web3j/web3j/releases

Now open android studio terminal and write 

```
solcjs app\keystore\contracts\Product.sol --bin --abi --optimize --overwrite -o app\keystore\contracts\build
```

Then write down the below command 

```
web3j solidity generate app\keystore\contracts\build\Product.bin app\keystore\contracts\build\Product.abi -o app\src\main\java -p io.left.core.newsblock.data.remote.contracts
```

Now we can use the contract api 

