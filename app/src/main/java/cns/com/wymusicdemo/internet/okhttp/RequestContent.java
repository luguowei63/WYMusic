package cns.com.wymusicdemo.internet.okhttp;

import java.util.Iterator;
import java.util.Map;

import okhttp3.FormBody;

/**
 * Created by luguowei on 2018/6/26.
 * 本类是封装的网络请求参数
 */

public class RequestContent {
    /**
     * 请求的路径。
     */
    private String url;
    /**
     * post 请求的参数，会从请求界面传入。
     */
    private FormBody paramsBody;
    /**
     * Get 请求参数的集合。
     */
    private Map<String, String> params;


    /**
     * @return
     */

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public FormBody getParamsBody() {
        return paramsBody;
    }

    public void setParamsBody(FormBody paramsBody) {
        this.paramsBody = paramsBody;
    }




    public class Build {
        /**
         * 请求的路径。
         */
        private String url;
        /**
         * post 请求的参数，会从请求界面传入。
         */
        private FormBody paramsBody;
        /**
         * Get 请求参数的集合。
         */
        private Map<String, String> params;

        private boolean isGet;

        public Build(String url) {
            this.url = url;
        }


        public Build formBody(FormBody body) {
            this.paramsBody = body;
            return this;
        }

        public Build params(Map<String, String> params) {
            this.params = params;
            return this;
        }

        public Build get() {
            this.isGet = true;
            return this;
        }

        public Build post() {
            this.isGet = false;
            return this;
        }

        public RequestContent build() {
            RequestContent content = new RequestContent();
            if (isGet) {
                content.setUrl(getGetUrl(this.params));
            } else {
                content.setParamsBody(this.paramsBody);
                content.setUrl(url);
            }
            return content;
        }
        /**
         * Get请求拼接参数形成URl。（暂未找到类似与xutils中RequestParams中的参数集成类）
         *
         * @param params
         * @return
         */
        public String getGetUrl(Map<String, String> params) {
            if (params != null) {
                Iterator<String> it = params.keySet().iterator();
                StringBuffer sb = null;
                while (it.hasNext()) {
                    String key = it.next();
                    String value = params.get(key);
                    if (sb == null) {
                        sb = new StringBuffer(url);
                        sb.append("?");
                    } else {
                        sb.append("&");
                    }
                    sb.append(key);
                    sb.append("=");
                    sb.append(value);
                }
            }
            return url;
        }

    }
}
