package com.liss;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import lombok.AllArgsConstructor;
import lombok.Data;

/** Class permettant de configurer les transaction **/

@Data @AllArgsConstructor 
public class DefinitionTransaction {
	
	DefaultTransactionDefinition definition;
	
	public DefinitionTransaction() {
		this.definition = new DefaultTransactionDefinition();
		this.definition.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
		this.definition.setTimeout(3);
	}
	
	
	
	
}
