import java.util.Random;
class HealthData {
    private double heartRate;
    private double temperature;
    private double bloodPressure;

    public HealthData(double heartRate, double temperature, double bloodPressure) {
        this.heartRate = heartRate;
        this.temperature = temperature;
        this.bloodPressure = bloodPressure;
    }

    // Getters and setters
    public double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    @Override
    public String toString() {
        return "HealthData{" +
                "heartRate=" + heartRate +
                ", temperature=" + temperature +
                ", bloodPressure=" + bloodPressure +
                '}';
    }
}
// DataCollector.java


class DataCollector {
    private Random random = new Random();

    public HealthData collectData() {
        double heartRate = 60 + random.nextDouble() * 40; // Simulate heart rate between 60-100 bpm
        double temperature = 36 + random.nextDouble() * 2; // Simulate temperature between 36-38°C
        double bloodPressure = 80 + random.nextDouble() * 40; // Simulate blood pressure between 80-120 mmHg

        return new HealthData(heartRate, temperature, bloodPressure);
    }
}
// HealthAnalyzer.java
class HealthAnalyzer {
    public void analyzeData(HealthData data) {
        System.out.println("Analyzing health data...");
        System.out.println(data);

        if (data.getHeartRate() < 60 || data.getHeartRate() > 100) {
            System.out.println("Warning: Abnormal heart rate detected!");
        }

        if (data.getTemperature() < 36 || data.getTemperature() > 38) {
            System.out.println("Warning: Abnormal body temperature detected!");
        }

        if (data.getBloodPressure() < 80 || data.getBloodPressure() > 120) {
            System.out.println("Warning: Abnormal blood pressure detected!");
        }
    }
}

// SmartHealthMonitoringSystem.java
public class SmartHealthMonitoringSystem {
    public static void main(String[] args) {
        DataCollector dataCollector = new DataCollector();
        HealthAnalyzer healthAnalyzer = new HealthAnalyzer();

        // Simulate continuous data collection and analysis
        for (int i = 0; i < 10; i++) {
            HealthData data = dataCollector.collectData();
            healthAnalyzer.analyzeData(data);

            try {
                Thread.sleep(1000); // Pause for 1 second between data collection
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

