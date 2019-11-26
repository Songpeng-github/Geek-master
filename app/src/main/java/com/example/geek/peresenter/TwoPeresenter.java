package com.example.geek.peresenter;

import com.example.geek.base.BasePeresenter;
import com.example.geek.bean.Beantwo;
import com.example.geek.bean.TwoBean;
import com.example.geek.model.AttetModel;
import com.example.geek.model.TwoModel;
import com.example.geek.network.ResultCallBack;
import com.example.geek.view.TwoView;

/**
 * name:&{宋佳羿}
 * date:2019/11/26
 * Time:&{TIME}
 */
public class TwoPeresenter extends BasePeresenter<TwoView> implements ResultCallBack {


    private TwoModel twomodel;
    public  void  twobean(String code){
         twomodel.two(code,this);

    }


     public  void  Beantwo(){
        twomodel.Beantwo(new ResultCallBack() {
            @Override
            public void onSuccess(Object bean) {
                view.showbeantwo((Beantwo) bean);
            }

            @Override
            public void onFail(String msg) {

            }
        });
     }

    @Override
    protected void initModel() {
        twomodel = new TwoModel();
        models.add(twomodel);
    }
    @Override
    public void onSuccess(Object bean) {
        view.showtwo((TwoBean) bean);
    }
    @Override
    public void onFail(String msg) {
    }
}
