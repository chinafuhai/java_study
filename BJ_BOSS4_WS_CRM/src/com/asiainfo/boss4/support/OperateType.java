package com.asiainfo.boss4.support;

import java.util.EnumSet;

import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;

/**
 * 操作类型枚举类
 * @author caohui
 *
 */
public enum OperateType {
	// 新增
	ADD("1"),
	// 保留
	KEEP("2"),
	// 取消
	CANCEL("3"),
	// 变更
	MODIFY("4"),
	// 查询
	QUERY("5"),
	// 延长有效期（更新失效时间）
	EXTEND("8"),
	
	// 删除
	REMOVE("16"),
	// 取消并复制一条新数据
	CANCEL_WITH_COPY("15"),
	// 备份数据至备份表，并删除原数据
	MOVE("17"),
	//回滚取消
	ROLLBACKCANCEL("97"),
	//回滚添加
	ROLLBACKADD("98"),
	//回滚修改、取消
	ROLLBACKOTHER("99");
	
	private String typeCode;

	private OperateType(String typeCode) {
		this.typeCode = typeCode;
	}
	
	public String getTypeCode() {
		return typeCode;
	}
	
	public static OperateType getInstance(String code) {
		EnumSet<OperateType> types = EnumSet.allOf(OperateType.class);
		for (OperateType type : types) {
			if (type.typeCode.equals(code)) {
				return type;
			}
		}
		throw new BossException(StatusCode.ILLEGAL_ENUMERATION_ERROR, "Undefined enum of ServiceAction: "+code);
	}
	
}
