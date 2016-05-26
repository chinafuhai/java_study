package com.asiainfo.openPlatform.support;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.asiainfo.openPlatform.domain.PoIntf;

/**
 * PoIntf 对象排序 根据PoId字段排序
 * @author zhangql
 *
 */
public class PoComparator implements Comparator<PoIntf> {

    public int compare(PoIntf o1, PoIntf o2) {
		return o1.getPoId().intValue()-o2.getPoId().intValue();
	}
    
}
