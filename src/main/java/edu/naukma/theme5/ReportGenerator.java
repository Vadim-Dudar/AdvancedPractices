package edu.naukma.theme5;

public abstract class ReportGenerator {

    final void generate() {
        collectData();
        formatReport();
        System.out.println("---Exported!---");
    }

    protected abstract void collectData();
    protected abstract void formatReport();

}
