public class SmartParkingBoy extends ParkingBoyAbstract {
    @Override
    public String parking(Car car) {
        String code = "false";
        Park park = null;
        for(Park item:parks){
            if (!item.isFull()){
                if (park == null){
                    park = item;
                }else if(item.getEmptySize()>park.getEmptySize()){
                    park = item;
                }
            }
        }
        if (park != null){
            code = park.parking(car);
        }
        if (code.equals("success")){
            code = park.getParkCode()+"";
        }
        return code;
    }
}
