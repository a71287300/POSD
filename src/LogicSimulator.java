import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Pattern;

public class LogicSimulator {
    private List<Device> circuit = new ArrayList<>();
    private List<Device> iPins  = new ArrayList<>();
    private List<Device> oPins = new ArrayList<>();
//判斷是整數嗎?
    private boolean isInteger(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

//判斷是浮點數嗎?
    private boolean isDouble(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
        return pattern.matcher(str).matches();
    }


//擱置中
    public String getSimulatorResult(Vector v){
        String result = new String();
        return result;
    };
//擱置part2
    public  String getTruthTable(){
        String table = new String();
        return table;
    };

    public boolean load(String pathname) throws IOException {
        FileReader fr = new FileReader(pathname);
        BufferedReader br = new BufferedReader(fr);

        int NI,NG,OUT=1;
        NI = Integer.parseInt(br.readLine()); //InputPin數
        NG = Integer.parseInt(br.readLine()); //Gate數

        if(NI<=0||NI>16)
            return false;
        if(NG<=0||NG>1000)
            return false;
        for(int i=0;i<NI;i++)
        {
            InputPin inputPin = new InputPin();
            iPins.add(inputPin);
        }

        for(int i=0;i<NG;i++) { //讀NG個Gate的內容
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gate = Integer.parseInt(st.nextToken()); //gate用來判斷AND NOT OR
            //gate => circuit
            switch (gate){
                case 1:
                    GateAND gateAND = new GateAND();
                    circuit.add(gateAND);
                    break;
                case 2:
                    GateOR gateOR = new GateOR();
                    circuit.add(gateOR);
                    break;
                case 3:
                    GateNot gateNot = new GateNot();
                    circuit.add(gateNot);
                    break;
                default:
                    System.out.println("File not found or file format error!!");
            }
            while (st.hasMoreTokens()){
                String s = st.nextToken();
                int x ; float f;
                /*if(isInteger(s)){ //這邊得到的整數都是負的，用來知道接到該gate的InputPin是哪隻
                    x = Integer.parseInt(s);
                    x=x*-1;
                    InputPin inputPin = (InputPin) iPins.get(x);
                    System.out.println(x);
                }
                else*/
                if(isDouble(s)){ //這邊得到的浮點數，用來知道從第幾號gate的幾號pin輸出到該gate
                    f = Float.parseFloat(s);

                    System.out.println(f);
                }
            }

        }
        System.out.println(NI+" input pins, "+OUT+ " output pins and "+NG+" gates");
        fr.close();
        return true;
    }
}
