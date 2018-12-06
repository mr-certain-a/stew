package orange.db;

import org.jooq.DSLContext;
import org.jooq.impl.SQLDataType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestInsert {

	@Autowired
	private DSLContext dsl;

	@ResponseBody
	@RequestMapping(value="/sample", method=RequestMethod.GET)
	public String sample() {
		
		dsl.createTable("modules")
	      .column("id", SQLDataType.INTEGER)
	      .column("name", SQLDataType.VARCHAR.length(50).nullable(false))
	      .column("version", SQLDataType.INTEGER)
	      .execute();
		
//		Result <Record> result = dsl.select()
//			.from("modules")
//			.fetch();
//
//		if (result.isEmpty()) {
//			return "failed";
//		}

//		for (Record r : result) {
//			logger.info("id : {} product name : {}", r.getValue(PRODUCTS.ID), r.getValue(PRODUCTS.NAME));
//		}

		return "success";
	}	


}
