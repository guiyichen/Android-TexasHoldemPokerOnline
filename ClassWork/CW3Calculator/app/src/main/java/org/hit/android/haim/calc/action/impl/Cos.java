package org.hit.android.haim.calc.action.impl;

import org.hit.android.haim.calc.action.ActionContext;
import org.hit.android.haim.calc.action.ActionResponse;
import org.hit.android.haim.calc.action.ArithmeticAction;

public class Cos implements ArithmeticAction {
    @Override
    public ActionResponse<Double> execute(ActionContext context) {
        return new ActionResponse<>(Math.cos(context.getValue()));
    }
}
