public class CannotAddInputPinException extends Exception {
    @Override
    public String getMessage() {
        return "不能再新增輸入，否則將導致無法計算。";
    }
}
