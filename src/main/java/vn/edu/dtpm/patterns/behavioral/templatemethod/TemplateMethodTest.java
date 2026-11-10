package vn.edu.dtpm.patterns.behavioral.templatemethod;

public class TemplateMethodTest {
    public static void test() {
        System.out.println("==================================================");
        System.out.println("--- KIỂM THỬ TEMPLATE METHOD: PIPELINE XỬ LÝ DỮ LIỆU ---");
        System.out.println("==================================================");

        // 1. Chạy quy trình với hệ thống MySQL
        DataProcessorTemplate mysqlETL = new MySQLDataProcessor();
        mysqlETL.processDataPipeline();

        // 2. Chạy quy trình với hệ thống Oracle
        DataProcessorTemplate oracleETL = new OracleDataProcessor();
        oracleETL.processDataPipeline();
    }
}

