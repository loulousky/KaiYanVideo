package kaiyan.lh.cn.kaiyanvideo.mvp.mainpage

/**
 * Created by admin on 2018/6/25.
 */
class HomeMainConnect{
    companion object {
        public interface Presenter{



        }


        public interface View{

            fun initcategoriesView();

        }


        public interface Mode{

            fun loadcategories(url:String);

        }








    }

}