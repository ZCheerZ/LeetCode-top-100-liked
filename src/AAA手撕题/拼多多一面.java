package AAA手撕题;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 拼多多一面 {
    // ip 段
    class CityIp{
        String city;
        String startIp;
        String endIp;
    }
    private List<CityIp> cityIpList;
    public  拼多多一面(List<CityIp> cityIpList){
        this.cityIpList = cityIpList;
        Collections.sort(this.cityIpList,(a,b)->{
            String [] aStart = a.startIp.split("\\.");
            String [] bStart = b.startIp.split("\\.");
            for (int i = 0; i < 4; i++) {
                int aNum = Integer.parseInt(aStart[i]);
                int bNum = Integer.parseInt(bStart[i]);
                if(aNum != bNum) return aNum - bNum;
            }
            return 0;
        });
    }

    public int checkIp(String ipsrc, String ip){
        String [] ipParts = ipsrc.split("\\.");
        String [] ipParts2 = ip.split("\\.");
        for (int i = 0; i < 4; i++) {
            int num1 = Integer.parseInt(ipParts[i]);
            int num2 = Integer.parseInt(ipParts2[i]);
            if(num1 != num2) return num1 - num2;
        }
        return 0;
    }

    public String findCityByIp(String ip){
        int left = 0, right = cityIpList.size() - 1;
        while(left < right){ // =
            int mid =  (left + right +1) / 2; // 注意这里是 +1，保证 mid 向右靠 如果不是这样就不需要
            CityIp midCityIp = cityIpList.get(mid);
            int cmpStart = checkIp(midCityIp.startIp, ip);
//            int cmpEnd = checkIp(midCityIp.endIp, ip);
//            if(cmpStart <= 0 && cmpEnd >= 0){
//                return midCityIp.city;
            if(cmpStart > 0){
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if(left < cityIpList.size()){
            CityIp cityIp = cityIpList.get(left);
            int cmpStart = checkIp(cityIp.startIp, ip);
            int cmpEnd = checkIp(cityIp.endIp, ip);
            if(cmpStart <= 0 && cmpEnd >= 0){
                return cityIp.city;
            }
        }
        return "未知城市";
    }

    public void 二分(int x,int n,int[] a){
        int l=0,r=n-1;
        int mid;
        // 找最left的值
        while(l<r){
            mid = (l+r)/2;
            if(a[mid]>=x) r=mid;
            else l = mid+1;
        }
        //此时l记录了最左边等于x的元素
        // 找最right的值
        l=0;
        r=n-1;
        while(l<r){
            mid = (l+r+1)/2; //请注意！
            if(a[mid]<=x) l=mid;
            else r = mid-1;
        }
        //此时l记录了最右边边等于x的元素
    }

    public static void main(String[] args) {
        // 先创建一个“模板对象”，用于 new 非静态内部类 CityIp
        拼多多一面 template = new 拼多多一面(new ArrayList<>());

        List<CityIp> list = new ArrayList<>();

        CityIp beijing = template.new CityIp();
        beijing.city = "北京";
        beijing.startIp = "100.123.1.234";
        beijing.endIp = "100.123.2.234";
        list.add(beijing);

        CityIp shanghai = template.new CityIp();
        shanghai.city = "上海";
        shanghai.startIp = "100.123.2.235";
        shanghai.endIp = "100.123.3.100";
        list.add(shanghai);

        CityIp guangzhou = template.new CityIp();
        guangzhou.city = "广州";
        guangzhou.startIp = "100.124.0.1";
        guangzhou.endIp = "100.124.0.255";
        list.add(guangzhou);

        // 真正用于查询的对象（构造函数会按 startIp 排序）
        拼多多一面 service = new 拼多多一面(list);

        String[] testIps = {
                "100.123.1.234", // 北京起点
                "100.123.2.234", // 北京终点
                "100.123.2.235", // 上海起点
                "100.123.3.100", // 上海终点
                "100.124.0.88",  // 广州区间内
                "100.123.3.101", // 不在任何区间
                "99.1.1.1"       // 不在任何区间
        };

        for (String ip : testIps) {
            System.out.println(ip + " -> " + service.findCityByIp(ip));
        }
    }

}
