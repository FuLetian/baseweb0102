package com.flt.service.manage.ball.report;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import com.flt.dao.client.BallMapper;
import com.flt.dao.model.BallExample;
import com.flt.service.manage.ball.IBallMapper;
import com.flt.service.manage.ball.report.dto.SortableDTO;
import com.flt.service.manage.base.BaseManageService;

@Service
public class FrequencyReport extends BaseManageService{

	public void createExcel(String path){
		
		Workbook wb=new HSSFWorkbook();
		Sheet s1=wb.createSheet("红球");
		
		int totals=countAll();
		List<SortableDTO> dtos=new ArrayList<>();
		for(int i=0;i<33;i++){
			int num=i+1;
			String title="红"+num;
			int count=countNum(num);
			BigDecimal frequency=new BigDecimal(count).divide(new BigDecimal(totals*6),10,RoundingMode.HALF_DOWN);
			
			fillValueRow(i,num,title,count,frequency,s1);
			
			SortableDTO dto=new SortableDTO();
			dto.setNum(num);
			dto.setCount(count);
			dtos.add(dto);
		}
		fillSortResultRow(dtos,s1,33);
		
		Sheet s2=wb.createSheet("蓝球");
		dtos.clear();
		for(int i=0;i<16;i++){
			int num=i+1;
			String title="蓝"+num;
			int count=countBlue(num);
			BigDecimal frequency=new BigDecimal(count).divide(new BigDecimal(totals),10,RoundingMode.HALF_DOWN);
			
			fillBlueValueRow(i,num,title,count,frequency,s2);
			
			SortableDTO dto=new SortableDTO();
			dto.setNum(num);
			dto.setCount(count);
			dtos.add(dto);
			
		}
		fillSortResultRow(dtos,s2,16);
		
		OutputStream out=null;
		try {
			out=new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(out==null){
			return;
		}
		try {
			wb.write(out);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void fillSortResultRow(List<SortableDTO> dtos, Sheet s1, int i) {
		// TODO Auto-generated method stub
		Object[] os=dtos.toArray();
		Arrays.sort(os);
		
		Row r=s1.createRow(i);
		Row countRow=s1.createRow(i+1);
		int k=0;
		for(Object o:os){
			r.createCell(k).setCellValue(((SortableDTO) o).getNum());
			countRow.createCell(k).setCellValue(((SortableDTO) o).getCount());
			k++;
		}
	}

	private void fillBlueValueRow(int i, int num, String title, int count,
			BigDecimal frequency, Sheet s) {
		// TODO Auto-generated method stub
		Row r=s.createRow(i);
		r.createCell(0).setCellValue(title);
		r.createCell(1).setCellValue(count);
		r.createCell(2).setCellValue(frequency.doubleValue());
	}

	private int countBlue(final int num) {
		// TODO Auto-generated method stub
		BallMapper m=getSqlSession().getMapper(BallMapper.class);
		
		return m.countByExample(new BallExample(){{
			this.createCriteria().andBlueEqualTo(num);
		}});
	}

	private void fillValueRow(int i, int num, String title, int count,
			BigDecimal frequency,Sheet s) {
		// TODO Auto-generated method stub
		Row r=s.createRow(i);
		
		r.createCell(0).setCellValue(title);
		r.createCell(1).setCellValue(count);
		r.createCell(2).setCellValue(frequency.doubleValue());
	}

	private int countNum(int num) {
		// TODO Auto-generated method stub
		IBallMapper m=getSqlSession().getMapper(IBallMapper.class);
		
		return m.countBallByNum(num);
	}

	private int countAll() {
		// TODO Auto-generated method stub
		BallMapper m=getSqlSession().getMapper(BallMapper.class);
		
		return m.countByExample(new BallExample());
	}
}
