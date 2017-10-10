package com.yoo.hon.common;

public class Test {
    public enum CATEGORY {
        STRATEGY(1), INDUSTRY(2), COMPANY(3), NEWS(4), GLOBAL_TREND(5);

        private  int category;

        CATEGORY(int category)
        {
            this.category = category;
        }

        public int getCode()
        {
            return this.category;
        }

        static public CATEGORY makeCategoryFromCode(int type)
        {
            switch (type)
            {
                case 1:
                    return STRATEGY;
                case 2:
                    return INDUSTRY;
                case 3:
                    return COMPANY;
                case 4:
                    return NEWS;
                case 5:
                    return GLOBAL_TREND;
                default:
                    return STRATEGY;
            }
        }
    }
    public CATEGORY category;
    public static void main(String args[]) {
        CATEGORY.makeCategoryFromCode(1);
    }

}
