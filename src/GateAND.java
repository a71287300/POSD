public class GateAND extends Device {
    @Override
    public boolean compute() {
        boolean answer = true;
        if (inputPins.size() > 1) {
            for (Device inputPin : inputPins) {
                answer = answer && inputPin.compute();
            }
            return answer;
        }
        return inputPins.get(0).compute();
    }
}
