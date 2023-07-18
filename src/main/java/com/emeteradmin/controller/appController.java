package com.emeteradmin.controller;

import com.emeteradmin.dto.CompRaspInfoDto;
import com.emeteradmin.dto.CompRaspInfoProjection;
import com.emeteradmin.dto.CompanyBranchDto;
import com.emeteradmin.dto.CompanyRaspDto;
import com.emeteradmin.entity.CompanyInfo;
import com.emeteradmin.entity.CompanyRaspInfo;
import com.emeteradmin.entity.MeterBase;
import com.emeteradmin.entity.RaspBase;
import com.emeteradmin.service.CompanyInfoService;
import com.emeteradmin.service.CompanyRaspInfoService;
import com.emeteradmin.service.MeterBaseService;
import com.emeteradmin.service.RaspBaseService;
import com.emeteradmin.utilobjects.Message;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@CrossOrigin("*")
public class appController {

    /*   Start of Dependency  Injection and Declaration  */

    @Autowired
    MeterBaseService meterBaseService;

    @Autowired
    RaspBaseService raspBaseService;

    @Autowired
    CompanyInfoService companyInfoService;

    @Autowired
    CompanyRaspInfoService companyRaspInfoService;

    @Value("${status}")
    private List<String> statusList = new ArrayList<>();

    /* End of Dependency Injection */


    @GetMapping({"/home","/"})
    public String welcome(HttpSession session){
        session.setAttribute("message",null);
        return "home";
    }


    /* ------------------------------------------------------ */
    /* Start of Code to list Meters, Raspberry & Company List */
    @GetMapping({"/showmeters"})
    public ModelAndView showMeters(HttpSession session){
        session.setAttribute("message",null);
        ModelAndView mav = new ModelAndView("meterBaseList");
        //List<MeterBase> meterlist = meterBaseRepository.findAll();
        List<MeterBase> meterlist = meterBaseService.findall();
        mav.addObject("meter", meterlist);
        return mav;
    }

    @GetMapping({"/showrasp"})
    public ModelAndView showRasp(HttpSession session){
        session.setAttribute("message",null);
        ModelAndView mav = new ModelAndView("raspBaseList");
        //List<RaspBase> rasplist = raspBaseRepository.findAll();
        List<RaspBase> rasplist = raspBaseService.findall();
        mav.addObject("rasp", rasplist);
        return mav;
    }

    @GetMapping({"/showcompany"})
    public ModelAndView showCompany(HttpSession session){
        session.setAttribute("message",null);
        ModelAndView mav = new ModelAndView("companyInfoList");
        //List<CompanyInfo> companylist = companyInfoRepository.findAll();
        List<CompanyInfo> companylist = companyInfoService.findall();
        mav.addObject("company", companylist);
        return mav;
    }

    /* End of Code to list Meters, Raspberry & Company List */
    /* --------------------------------------------------------------------------------------------------------- */



    /* ----------------------------------------------------------------------- */
    /* Start of Code to show form for adding a new Meters, Raspberry & Company */
    @GetMapping("/addMeterForm")
    public ModelAndView addMeterForm() {
        ModelAndView mav = new ModelAndView("add-meter-form");
        MeterBase newMeterBase = new MeterBase();
        mav.addObject("meter", newMeterBase);
        mav.addObject("status", statusList);
        return mav;
    }

    @GetMapping("/addRaspForm")
    public ModelAndView addRaspForm() {
        ModelAndView mav = new ModelAndView("add-rasp-form");
        RaspBase newRaspBase = new RaspBase();
        mav.addObject("rasp", newRaspBase);
        mav.addObject("status", statusList);
        return mav;
    }
    @GetMapping("/addCompanyForm")
    public ModelAndView addCompanyForm() {
        ModelAndView mav = new ModelAndView("add-company-form");
        CompanyInfo newcompanyInfo = new CompanyInfo();
        mav.addObject("company", newcompanyInfo);
        return mav;
    }

    /* End of Code to show form for adding a new Meters, Raspberry & Company */
    /* ---------------------------------------------------------------------------------------------------------- */



    /* ------------------------------------------------------ */
    /* Start of Code to save a new Meter, Raspberry & Company */
    @PostMapping("/saveMeter")
	public String saveMeter(@ModelAttribute MeterBase meterBase, HttpSession session) {

        try {
                meterBaseService.save(meterBase);
                session.setAttribute("message", new Message("Meter information saved successfully","success"));
            }
        catch (Exception e) {
            session.setAttribute("message", new Message("Meter information not saved !!! Input error","danger"));

        }
		return "redirect:/addMeterForm";
	}

    @PostMapping("/saveRasp")
    public String saveRasp(@ModelAttribute RaspBase raspBase, HttpSession session) {
        try {
                raspBaseService.save(raspBase);
                session.setAttribute("message", new Message("Raspberry information saved successfully","success"));
            }
            catch (Exception e) {
                    session.setAttribute("message", new Message("Raspberry information not saved !!! Input error","danger"));
            }
        return "redirect:/addRaspForm";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute CompanyInfo companyInfo, HttpSession session) {

     try {
            companyInfoService.save(companyInfo);
            session.setAttribute("message", new Message("Company information saved successfully","success"));
        }
            catch (Exception e) {
            session.setAttribute("message", new Message("Company information not saved !!! Input error","danger"));
        }
        return "redirect:/addCompanyForm";
    }


    /* ---------------------------------------------------------------------------------------------------------- */




    /* --------------------------------------------------------------- */
    /* Start of Code to show update form of Meter, Raspberry & Company */
	@GetMapping("/showMeterUpdateForm")
	public ModelAndView showMeterUpdateForm(@RequestParam Long mbId) {
        Optional<MeterBase> meterBase;
		ModelAndView mav = new ModelAndView("add-meter-form");
        meterBase = meterBaseService.findById(mbId);
		mav.addObject("meter", meterBase);
        mav.addObject("status", statusList);
		return mav;
	}
    @GetMapping("/showRaspUpdateForm")
    public ModelAndView showRaspUpdateForm(@RequestParam Long rbId) {
        Optional<RaspBase> raspBase;
        ModelAndView mav = new ModelAndView("add-rasp-form");
        raspBase = raspBaseService.findById(rbId);
        mav.addObject("rasp", raspBase);
        mav.addObject("status", statusList);
        return mav;
    }
    @GetMapping("/showCompanyUpdateForm")
    public ModelAndView showCompanyUpdateForm(@RequestParam String ciId) {
        Optional<CompanyInfo> companyInfo;
        ModelAndView mav = new ModelAndView("add-company-form");
        companyInfo = companyInfoService.findById(ciId);
        mav.addObject("company", companyInfo);
        return mav;
    }

    /* ---------------------------------------------------------------------------------------------------------- */



    /* --------------------------------------------------------------- */
    /* Start of Code to delete of Meter, Raspberry & Company */
    @GetMapping("/deleteMeter")
    public String deleteMeter(@RequestParam Long mbId) {
        meterBaseService.deleteById(mbId);
        return "redirect:/showmeters";
    }

    @GetMapping("/deleteRasp")
    public String deleteRasp(@RequestParam Long rbId) {
        raspBaseService.deleteById(rbId);
        return "redirect:/showrasp";
    }

    @GetMapping("/deleteCompany")
    public String deleteCompany(@RequestParam String ciId) {
        companyInfoService.deleteById(ciId);
        return "redirect:/showcompany";
    }


    /* ---------------------------------------------------------------------------------------------------------- */



    /* --------------------------------------------------------------- */
    /* Start of Code for linking Raspberry with Company */

    @GetMapping("/showraspcomplink")
    public ModelAndView showRaspCompLink(HttpSession session){
        session.setAttribute("message",null);
        ModelAndView mav = new ModelAndView("rasp-company-link");
        List<CompRaspInfoDto> compRaspInfoDtoList = new ArrayList<>();
        List<CompRaspInfoProjection> compRaspInfoProjectionList = companyRaspInfoService.findRaspWithCompany();

        for (CompRaspInfoProjection clist: compRaspInfoProjectionList) {
            CompRaspInfoDto compRaspInfoDto = new CompRaspInfoDto(clist.getraspId(),
                                                  clist.getraspMacId(),clist.getraspModel(),clist.getraspConnStruct(),
                                                  clist.getraspOsVer(),clist.getraspDesc(),clist.getraspStatus(),
                                                  clist.getraspManfName(),clist.getcmpId(),clist.getcmpName(),clist.getcmpBranch(),
                                                  clist.getcmpraspId());
            compRaspInfoDtoList.add(compRaspInfoDto);
        }
        mav.addObject("comprasp", compRaspInfoDtoList);
        return mav;
    }

        @GetMapping("/showRaspCompLinkForm")
    public ModelAndView showRaspCompLinkForm(@RequestParam Long rbId) {

        ModelAndView mav = new ModelAndView("rasp-company-update");
        try {
                String compid;
                CompRaspInfoProjection compRaspInfoProjection;
                List<CompanyBranchDto> companyBranchDto;
                CompanyRaspDto companyRaspDto = new CompanyRaspDto();
                compRaspInfoProjection = companyRaspInfoService.findRaspWithCompanyById(rbId);

                if (compRaspInfoProjection.getcmpId() == null) {
                    compid = "0";
                }
                else {
                    compid = compRaspInfoProjection.getcmpId();
                }

                companyRaspDto.setCompid(compid);
                companyRaspDto.setRaspmacid(compRaspInfoProjection.getraspMacId());
                companyRaspDto.setRaspstatus(compRaspInfoProjection.getraspStatus());
                companyRaspDto.setCrid(compRaspInfoProjection.getcmpraspId());

                companyBranchDto = companyInfoService.getAllCompanyWithBranch();


                mav.addObject("comprasp",companyRaspDto);
                mav.addObject("compbranch",companyBranchDto);
        }
        catch (Exception e){

            System.out.println("Error module comparasplink form");


        }
        return mav;
    }

    @PostMapping("/saveCompRaspLink")
    public String saveCompRaspLink(@ModelAttribute CompanyRaspDto compRaspDto, HttpSession session) {

        try {
                if (compRaspDto.getCrid() == 0) {
                    CompanyRaspInfo companyRaspInfo = new CompanyRaspInfo();
                    companyRaspInfo.setCr_rasp_macid(compRaspDto.getRaspmacid());
                    companyRaspInfo.setCr_rasp_status(compRaspDto.getRaspstatus());
                    companyRaspInfo.setCr_companyinfo_id(compRaspDto.getCompid());
                    System.out.println("Rasp macid : " + compRaspDto.getRaspmacid());
                    System.out.println("Rasp Status : " + compRaspDto.getRaspstatus());
                    System.out.println("Rasp compid : " + compRaspDto.getCompid());
                    companyRaspInfoService.save(companyRaspInfo);
                }
                else{
                    companyRaspInfoService.UpdateRaspCompany(compRaspDto.getCrid(),compRaspDto.getCompid());
                }


                session.setAttribute("message", new Message("Company Raspberry Link saved successfully","success"));
        }
        catch (Exception e) {
            session.setAttribute("message", new Message("Company Raspberry Link  information not saved !!! Input error","danger"));
            System.out.println("Exception is : " + e);
        }
        return "redirect:/showraspcomplink";
    }

    /* ---------------------------------------------------------------------------------------------------------- */

}
