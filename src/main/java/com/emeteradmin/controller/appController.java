package com.emeteradmin.controller;

import com.emeteradmin.entity.CompanyInfo;
import com.emeteradmin.entity.MeterBase;
import com.emeteradmin.entity.RaspBase;
import com.emeteradmin.repository.CompanyInfoRepository;
import com.emeteradmin.repository.MeterBaseRepository;
import com.emeteradmin.repository.RaspBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@CrossOrigin("*")
public class appController {

    @Autowired
    MeterBaseRepository meterBaseRepository;

    @Autowired
    RaspBaseRepository raspBaseRepository;

    @Autowired
    CompanyInfoRepository companyInfoRepository;


    @GetMapping({"/home","/"})
    public String welcome(){
        return "home";
    }

    /* @GetMapping("/showmeters")
    public List<MeterSummitEntity> showMeters(){

        List<MeterSummitEntity> meterSummitEntity = meterSummitRepository.findAll();
        //ModelAndView mav = new ModelAndView("meterSummitList");
        //List<meterSummitEntity> meterlist = meterSummitRepository.findAll();
        //mav.addObject("meter", meterlist);
        return meterSummitEntity;
    } */


    @GetMapping({"/showmeters"})
    public ModelAndView showMeters(){
        ModelAndView mav = new ModelAndView("meterBaseList");
        List<MeterBase> meterlist = meterBaseRepository.findAll();
        mav.addObject("meter", meterlist);
        return mav;
    }

    @GetMapping({"/showrasp"})
    public ModelAndView showRasp(){
        ModelAndView mav = new ModelAndView("raspBaseList");
        List<RaspBase> rasplist = raspBaseRepository.findAll();
        mav.addObject("rasp", rasplist);
        return mav;
    }

    @GetMapping({"/showcompany"})
    public ModelAndView showCompany(){
        ModelAndView mav = new ModelAndView("companyInfoList");
        List<CompanyInfo> companylist = companyInfoRepository.findAll();
        mav.addObject("company", companylist);
        return mav;
    }

    @GetMapping("/addMeterForm")
    public ModelAndView addMeterForm() {
        ModelAndView mav = new ModelAndView("add-meter-form");
        MeterBase newMeterBase = new MeterBase();
        mav.addObject("meter", newMeterBase);
        return mav;
    }

    @GetMapping("/addRaspForm")
    public ModelAndView addRaspForm() {
        ModelAndView mav = new ModelAndView("add-rasp-form");
        RaspBase newRaspBase = new RaspBase();
        mav.addObject("rasp", newRaspBase);
        return mav;
    }

    @GetMapping("/addCompanyForm")
    public ModelAndView addCompanyForm() {
        ModelAndView mav = new ModelAndView("add-company-form");
        CompanyInfo newcompanyInfo = new CompanyInfo();
        mav.addObject("company", newcompanyInfo);
        return mav;
    }

    @PostMapping("/saveMeter")
	public String saveMeter(@ModelAttribute MeterBase meterBase) {
        meterBaseRepository.save(meterBase);
		return "redirect:/showmeters";
	}

    @PostMapping("/saveRasp")
    public String saveRasp(@ModelAttribute RaspBase raspBase) {
        raspBaseRepository.save(raspBase);
        return "redirect:/showrasp";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute CompanyInfo companyInfo) {

        //System.out.println("Company Id : " + companyInfo.getCi_id());
        //return "redirect:/showcompany";

        companyInfoRepository.save(companyInfo);
        return "redirect:/showcompany";
    }

    /*

	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Long employeeId) {
		ModelAndView mav = new ModelAndView("add-employee-form");
		Employee employee = eRepo.findById(employeeId).get();
		mav.addObject("employee", employee);
		return mav;
	}

	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam Long employeeId) {
		eRepo.deleteById(employeeId);
		return "redirect:/list";
	}


     */

}
