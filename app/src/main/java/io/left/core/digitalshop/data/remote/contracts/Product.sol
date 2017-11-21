pragma solidity ^0.4.15;
contract Product {

  struct ProductStruct {
    uint[] productName;
    uint[] productUnit;
    
  }

  mapping(address => ProductStruct) productStructs;

  function Product() {
    // nothing to do
  }

  function appendProduct(uint name,uint unit) returns(uint length) {
     productStructs[msg.sender].productUnit.push(unit);
    return productStructs[msg.sender].productName.push(name);
  }

  function getCount() constant returns(uint length) {
    return productStructs[msg.sender].productName.length;
  }

  function getProductNameAtIndex(uint index) constant returns(uint value) {
    return productStructs[msg.sender].productName[index];
  }
  function getProductUnitAtIndex(uint index) constant returns(uint value) {
    return productStructs[msg.sender].productUnit[index];
  }
  
  function transactionProduct(uint name,uint unit,uint index)constant returns(bool){
    productStructs[msg.sender].productUnit[index] = productStructs[msg.sender].productUnit[index] - unit;
    return true;
  }
  
  function transactionEther() payable returns(bool){
     return true;
  }
}