package org.djohnson.sblogic.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.djohnson.sblogic.model.JasperBean;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

/**
 * JasperController provides a REST endpoint for generating a jasper report
 * that will be downloaded as an excel file.
 * 
 * This example is based on https://examples.javacodegeeks.com/jasperreports-with-spring-boot/
 * 
 * @author DJohnson
 * @since 1.0.0
 *
 */
@RestController
@RequestMapping("/api")
public class JasperController {
	
	/**
	 * Generate a jasper report and set the response to download it.
	 * 
	 * @param response			the response
	 * @throws IOException		any IO exception
	 * @throws JRException		any jasper report exception
	 */
	@RequestMapping(value= "/jasper", method = RequestMethod.GET)
    public void getDocument(HttpServletResponse response) throws IOException, JRException {

		// Get the report from the resources file. 
        String sourceFileName = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "SampleJasperReport.jasper").getAbsolutePath();
        
        List<JasperBean> dataList = generateReportData();
        
        // Create a Jasper bean collection (ie - data)
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
        // Create some report parameters (empty)
        Map<String, Object> parameters = new HashMap<String, Object>();
        // Fill the report from the actual template file, parameter and data
        JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFileName, parameters, beanColDataSource);
        
        // Create an exporter for excel and put the data in it
        JRXlsxExporter exporter = new JRXlsxExporter();
        SimpleXlsxReportConfiguration reportConfigXLS = new SimpleXlsxReportConfiguration();
        reportConfigXLS.setSheetNames(new String[] { "sheet1" });
        exporter.setConfiguration(reportConfigXLS);
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
        
        response.setHeader("Content-Disposition", "attachment;filename=jasperReport.xlsx");
        response.setContentType("application/octet-stream");
        
        exporter.exportReport();
    }
	
	/**
	 * Generate a list of data points for the report.
	 * @return a list of {@link JasperBean}
	 */
	private List<JasperBean> generateReportData() {
		
		List<JasperBean> dataList = new ArrayList<JasperBean>();
		
		for (int i = 0; i < 10; i++) {
			JasperBean bean = new JasperBean();
	        bean.setName("name " + i);
	        bean.setColor("color " + 1);
	        dataList.add(bean);
		}
		
		return dataList;
		
	}

}
