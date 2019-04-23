public class GateOR extends Device {
    @Override
    public boolean compute() {
        boolean answer = false;
        if (inputPins.size() > 1) {
            for (Device inputPin : inputPins) {
                answer = answer || inputPin.compute();
            }
            return answer;
        }
        return inputPins.get(0).compute();
    }
}
