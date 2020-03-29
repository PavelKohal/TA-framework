package service;

import model.CloudPlatformSpecification;

public class SpecificationCreator {

    public final static String NUMBER_OF_INSTANCES = "4";
    public final static String OPERATION_SYSTEM = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
    public final static String MACHINE_CLASS = "Regular";
    public final static String MACHINE_TYPE = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
    public final static boolean ADD_GPU = true;
    public final static String NUMBER_GPU = "1";
    public final static String GPU_TYPE = "NVIDIA Tesla V100";
    public final static String LOCAL_SSD = "2x375 GB";
    public final static String DATACENTER_LOCATION = "Frankfurt (europe-west3)";
    public final static String COMMITED_USAGE = "1 Year";

    public static CloudPlatformSpecification withCredentialsFromProperty(){
        return new CloudPlatformSpecification(NUMBER_OF_INSTANCES, OPERATION_SYSTEM, MACHINE_CLASS,
                MACHINE_TYPE, ADD_GPU, NUMBER_GPU, GPU_TYPE, LOCAL_SSD, DATACENTER_LOCATION, COMMITED_USAGE);
    }
}
