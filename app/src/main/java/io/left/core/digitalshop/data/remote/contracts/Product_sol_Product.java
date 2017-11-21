package io.left.core.digitalshop.data.remote.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.1.1.
 */
public final class Product_sol_Product extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b61030a8061001e6000396000f3006060604052600436106100775763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166318bd630f811461007c5780637aa3edcb146100a4578063a23fa384146100d4578063a87d942c146100ea578063b5e13016146100fd578063eb683a8014610116575b600080fd5b341561008757600080fd5b61009260043561011e565b60405190815260200160405180910390f35b34156100af57600080fd5b6100c0600435602435604435610158565b604051901515815260200160405180910390f35b34156100df57600080fd5b6100926004356101d9565b34156100f557600080fd5b6100926101fd565b341561010857600080fd5b61009260043560243561021a565b6100c0610292565b600160a060020a033316600090815260208190526040812060010180548390811061014557fe5b9060005260206000209001549050919050565b600160a060020a033316600090815260208190526040812060010180548491908490811061018257fe5b9060005260206000209001540360008033600160a060020a0316600160a060020a03168152602001908152602001600020600101838154811015156101c357fe5b6000918252602090912001555060019392505050565b600160a060020a033316600090815260208190526040812080548390811061014557fe5b600160a060020a0333166000908152602081905260409020545b90565b600160a060020a033316600090815260208190526040812060019081018054909181016102478382610297565b506000918252602080832091909101849055600160a060020a03331682528190526040902080546001810161027c8382610297565b6000928352602090922001849055905092915050565b600190565b8154818355818115116102bb576000838152602090206102bb9181019083016102c0565b505050565b61021791905b808211156102da57600081556001016102c6565b50905600a165627a7a723058201642cab16c9cbb6299fa6523ab8f41cb0dab83600a098f972aebcf75f7af41540029";

    private Product_sol_Product(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private Product_sol_Product(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<BigInteger> getProductUnitAtIndex(BigInteger index) {
        Function function = new Function("getProductUnitAtIndex", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> transactionProduct(BigInteger name, BigInteger unit, BigInteger index) {
        Function function = new Function("transactionProduct", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(name), 
                new org.web3j.abi.datatypes.generated.Uint256(unit), 
                new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> getProductNameAtIndex(BigInteger index) {
        Function function = new Function("getProductNameAtIndex", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getCount() {
        Function function = new Function("getCount", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> appendProduct(BigInteger name, BigInteger unit) {
        Function function = new Function(
                "appendProduct", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(name), 
                new org.web3j.abi.datatypes.generated.Uint256(unit)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transactionEther(BigInteger weiValue) {
        Function function = new Function(
                "transactionEther", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public static RemoteCall<Product_sol_Product> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Product_sol_Product.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Product_sol_Product> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Product_sol_Product.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static Product_sol_Product load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Product_sol_Product(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Product_sol_Product load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Product_sol_Product(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
