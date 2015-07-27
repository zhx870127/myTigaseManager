package com.letv.tigase.controller.base;

import com.letv.common.utils.wrap.WrapMapper;
import com.letv.common.utils.wrap.Wrapper;

/**
 * WrapController ,wrap simple result return.
 * 
 * @author lijianzhong
 * 
 */
public abstract class WrapController {

    protected Wrapper<?> ok() {
        return WrapMapper.ok();
    }

    protected Wrapper<?> error() {
        return WrapMapper.error();
    }

    protected Wrapper<?> illegalArgument() {
        return WrapMapper.illegalArgument();
    }
}
