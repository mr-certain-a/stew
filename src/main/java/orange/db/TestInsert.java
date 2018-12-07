package orange.db;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestInsert {

	@Autowired
	private DSLContext dsl;
	
    @GetMapping("/insert")
    @ResponseBody
    public String insert() {
    	
    	dsl.insertInto(DSL.table("\"modules\""), 
    			DSL.field("\"id\""), DSL.field("\"name\""), DSL.field("\"version\""), DSL.field("\"binary\""))
    		.values(1, "first", 100, "first moudle".getBytes())
    		.execute();
    	
    	return "insert: success";
    }


	@ResponseBody
	@RequestMapping(value="/createDataBase", method=RequestMethod.GET)
	public String createDataBase() {
		
		dsl.createTableIfNotExists("modules")
	      .column("id", SQLDataType.INTEGER)
	      .column("name", SQLDataType.VARCHAR.length(50).nullable(false))
	      .column("version", SQLDataType.INTEGER)
	      .column("binary", SQLDataType.BLOB)
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

		return "createDataBase: success";
	}
	


}
