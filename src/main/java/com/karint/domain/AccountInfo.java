package com.karint.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public class AccountInfo {
	@Column
	private Long userNo;
	@Column
	private String accountId;
	@Column
	private Long accountNo;
}
