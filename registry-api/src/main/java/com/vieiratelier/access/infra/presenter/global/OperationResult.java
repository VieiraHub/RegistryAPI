package com.vieiratelier.access.infra.presenter.global;

public class OperationResult {
	
	private OperationNameEnum operationNameEnum;
	private OperationResultEnum operationResultEnum;
	
	protected OperationResult() {}
	
	public OperationResult(OperationNameEnum operationNameEnum) {
		this.operationNameEnum = operationNameEnum;
	}

	public OperationResult(OperationNameEnum operationNameEnum, OperationResultEnum operationResultEnum) {
		this.operationNameEnum = operationNameEnum;
		this.operationResultEnum = operationResultEnum;
	}

	public OperationNameEnum getOperationName() {
		return operationNameEnum;
	}

	public OperationResultEnum getOperationResult() {
		return operationResultEnum;
	}

	public void setOperationResult(OperationResultEnum operationResultEnum) {
		this.operationResultEnum = operationResultEnum;
	}
}

