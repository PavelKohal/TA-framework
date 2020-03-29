package service;

import model.CloudPlatformSpecification;

public class SpecificationCreator {

//    public final static String NUMBER_OF_INSTANCES = "4";
//    public final static String OPERATION_SYSTEM = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
//    public final static String MACHINE_CLASS = "Regular";
//    public final static String MACHINE_TYPE = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
//    public final static String ADD_GPU = "on";
//    public final static String NUMBER_GPU = "1";
//    public final static String GPU_TYPE = "NVIDIA Tesla V100";
//    public final static String LOCAL_SSD = "2x375 GB";
//    public final static String DATACENTER_LOCATION = "Frankfurt (europe-west3)";
//    public final static String COMMITED_USAGE = "1 Year";

    public final static String TESTDATA_NUMBER_OF_INSTANCES = "testdata.number.instances";
    public final static String TESTDATA_OPERATION_SYSTEM = "testdata.operation.system";
    public final static String TESTDATA_MACHINE_CLASS = "testdata.machine.class";
    public final static String TESTDATA_MACHINE_TYPE = "testdata.machine.type";
    public final static String TESTDATA_ADD_GPU = "testdata.add.gpu";
    public final static String TESTDATA_NUMBER_GPU = "testdata.number.gpu";
    public final static String TESTDATA_GPU_TYPE = "testdata.type.gpu";
    public final static String TESTDATA_LOCAL_SSD = "testdata.local.ssd";
    public final static String TESTDATA_DATACENTER_LOCATION = "testdata.datacenter.location";
    public final static String TESTDATA_COMMITED_USAGE = "testdata.committed.usage";

    public static CloudPlatformSpecification withCredentialsFromProperty(){
        return new CloudPlatformSpecification(TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(TESTDATA_OPERATION_SYSTEM), TestDataReader.getTestData(TESTDATA_MACHINE_CLASS),
                TestDataReader.getTestData(TESTDATA_MACHINE_TYPE), TestDataReader.getTestData(TESTDATA_ADD_GPU),
                TestDataReader.getTestData(TESTDATA_NUMBER_GPU), TestDataReader.getTestData(TESTDATA_GPU_TYPE),
                TestDataReader.getTestData(TESTDATA_LOCAL_SSD), TestDataReader.getTestData(TESTDATA_DATACENTER_LOCATION),
                TestDataReader.getTestData(TESTDATA_COMMITED_USAGE));
    }
}
