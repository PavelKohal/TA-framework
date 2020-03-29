package model;

import java.util.Objects;

public class CloudPlatformSpecification {

    private String numberOfInstances;
    private String operationSystem;
    private String machineClass;
    private String machineType;
    private boolean addGPU;
    private String numberGPU;
    private String GPUType;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;

    public CloudPlatformSpecification(String numberOfInstances, String operationSystem,
                                      String machineClass, String machineType, boolean addGPU,
                                      String numberGPU, String GPUType, String localSSD,
                                      String datacenterLocation, String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.operationSystem = operationSystem;
        this.machineClass = machineClass;
        this.machineType = machineType;
        this.addGPU = addGPU;
        this.numberGPU = numberGPU;
        this.GPUType = GPUType;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public String getMachineType() {
        return machineType;
    }

    public boolean isAddGPU() {
        return addGPU;
    }

    public String getNumberGPU() {
        return numberGPU;
    }

    public String getGPUType() {
        return GPUType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }
}
