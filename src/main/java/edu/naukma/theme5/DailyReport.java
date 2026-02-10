package edu.naukma.theme5;

public class DailyReport extends ReportGenerator{

    @Override
    protected void collectData() {
        System.out.println("Collecting data..");
    }

    @Override
    protected void formatReport() {
        System.out.println("Formating report..");
    }

}
