package UI;

import BLL.DTO.DayReportDTO;
import BLL.DTO.SprintReportDTO;
import BLL.DTO.WorkerDTO;
import BLL.ReportService;
import DAL.Entities.Worker;
import UI.ViewModel.DayReportView;
import UI.ViewModel.SprintReportView;
import UI.ViewModel.WorkerView;

public class ReportController {

    private ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    public void addDayReport(DayReportView report) {
        var w = new WorkerDTO(report.getId());
        var r = new DayReportDTO(w);
        service.addDayReport(r);
        report.setId(r.getId());
    }

    public void addSprintReport(SprintReportView report) {
        var w = new WorkerDTO(report.getOwner().getId());
        var r = new SprintReportDTO(w, report.getEndTime());
        service.addSprintReport(r);
        report.setId(r.getId());
    }

    public void writeReport(WorkerView worker, SprintReportView sprintReport, String text) throws Exception {
        var w = new WorkerDTO(worker.getId());
        var r = new SprintReportDTO(sprintReport.getId());
        service.writeReport(w, r, text);
    }

    public void saveSprintReport(WorkerView worker, SprintReportView sprintReport) throws Exception {
        var w = new WorkerDTO(worker.getId());
        var owner = new WorkerDTO(sprintReport.getOwner().getId());
        var r = new SprintReportDTO(owner, sprintReport.getEndTime());
        service.saveSprintReport(w, r);
    }
}
