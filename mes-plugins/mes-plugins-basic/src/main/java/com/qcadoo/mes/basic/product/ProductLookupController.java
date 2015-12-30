package com.qcadoo.mes.basic.product;

import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qcadoo.mes.basic.BasicLookupController;
import com.qcadoo.mes.basic.controllers.dataProvider.DataProvider;
import com.qcadoo.mes.basic.controllers.dataProvider.dto.ProductDTO;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "product")
public class ProductLookupController extends BasicLookupController {

    @Autowired
    private DataProvider dataProvider;

    @RequestMapping(value = "lookup", method = RequestMethod.GET)
    @Override
    public ModelAndView getLookupView(Map<String, String> arguments, Locale locale) {
        ModelAndView mav = getModelAndView("product", "genericLookup", locale);

        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "records", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public List<ProductDTO> getRecords(@RequestParam String sidx, @RequestParam String sord) {
        return dataProvider.getAllProducts(sidx, sord);
    }

    @ResponseBody
    @RequestMapping(value = "config", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Map<String, Object> getConfig() {
        return getConfigMap(Arrays.asList("number", "name"));
    }

}
