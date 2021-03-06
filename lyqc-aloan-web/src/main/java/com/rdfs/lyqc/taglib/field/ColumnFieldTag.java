package com.rdfs.lyqc.taglib.field;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.TagSupport;

import com.rdfs.core.utils.StringUtils;
import com.rdfs.lyqc.cache.utils.CacheCxtUtil;
import com.rdfs.lyqc.common.utils.JacksonUtil;
import com.rdfs.lyqc.system.entity.SyDictItem;
import com.rdfs.lyqc.system.entity.SyRegion;


/**
 * 为了使用字典，自定义select标签
 *
 */
public class ColumnFieldTag extends TagSupport implements DynamicAttributes{

	/**
	 * 
	 */
	private static final long serialVersionUID = 729252097490938995L;
	private String id ;
	private String name;
	private String value;
	private String clazz;
	private String dataField;
	private String width;
	private String title;
	private String style;
	private String type;
	private String tooltip;
	private String format;
	private String renderFn;
	
	private Map<String, String> dynamicAttributes = new HashMap<String, String>(); 
	
	@Override
    public int doStartTag() throws JspException {
		return EVAL_PAGE;
	}
	
	@Override
	public int doEndTag() throws JspException {
		//JspWriter writer = pageContext.getOut();
		try{
			StringBuffer sb = new StringBuffer("<th");
			for(Iterator<String> iter = dynamicAttributes.keySet().iterator();iter.hasNext();){
				String key = iter.next();
				sb.append(" " + key + "='" + dynamicAttributes.get(key) + "'");
			}
			if(!StringUtils.isBlank(this.getId())){
				sb.append(" id='" + this.getId() + "'");
			}
			if(!StringUtils.isBlank(this.getValue())){
				sb.append(" value='" + this.getValue() + "'");
			}
			if(!StringUtils.isBlank(this.getClazz())){
				sb.append(" class='" + this.getClazz() + "'");
			}
			if(!StringUtils.isBlank(this.getTooltip())){
				sb.append(" tooltip='" + this.getTooltip() + "'");
			}
			if(!StringUtils.isBlank(this.getTitle())){
				sb.append(" title='" + this.getTitle() + "'");
			}
			if(!StringUtils.isBlank(this.getStyle())){
				sb.append(" style='" + this.getStyle() + "'");
			}
			if(!StringUtils.isBlank(this.getWidth())){
				sb.append(" width='" + this.getWidth() + "'");
			}
			if(!StringUtils.isBlank(this.getFormat())){
				sb.append(" format='" + this.getFormat() + "'");
			}
			if(!StringUtils.isBlank(this.getRenderFn())){
				sb.append(" renderFn='" + this.getRenderFn() + "'");
			}
			if(!StringUtils.isBlank(this.getDataField())){
				sb.append(" dataField='" + this.getDataField() + "'");
			}
			if(!StringUtils.isBlank(this.getType())){
				sb.append(" type='" + this.getType() + "'");
			}
			sb.append(">");
			if(!StringUtils.isBlank(this.getType())){
				if(this.getType().equalsIgnoreCase("dict")){
					if(!StringUtils.isBlank(this.getFormat())){
						List<SyDictItem> dictItems = CacheCxtUtil.getDicList(this.getFormat());
						if(dictItems!=null && !dictItems.isEmpty()){
							sb.append("<input type='hidden' value='"+JacksonUtil.toJson(dictItems)+"' dict-code='"+this.getFormat()+"'>");
						}
					}
				}
				if(this.getType().equalsIgnoreCase("region")){
					List<SyRegion> regions = CacheCxtUtil.getRegionList();
					sb.append("<input type='hidden' value='"+JacksonUtil.toJson(regions)+"' class='region-all'>");
				}
			}
			if(!StringUtils.isBlank(this.getName())){
				sb.append( this.getName() );
			}
			sb.append("</th>");
			if (getParent() instanceof TableFieldTag) {
				TableFieldTag tableFieldTag = (TableFieldTag) getParent();
				tableFieldTag.getColumns().add(sb.toString());
			}
			//writer.print(sb.toString());
		} catch(Exception e){
			
		}
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
		if(localName.equals("class")){
			setClazz(String.valueOf(value));
		} else {
			if(!StringUtils.isBlankObj(value)){
				dynamicAttributes.put(localName, String.valueOf(value));  
			}
		}
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getTooltip() {
		return tooltip;
	}

	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getDataField() {
		return dataField;
	}

	public void setDataField(String dataField) {
		this.dataField = dataField;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getRenderFn() {
		return renderFn;
	}

	public void setRenderFn(String renderFn) {
		this.renderFn = renderFn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
