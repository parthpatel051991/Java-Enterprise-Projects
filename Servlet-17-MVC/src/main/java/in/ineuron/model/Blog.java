package in.ineuron.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog implements Serializable {


	
	private static final long serialVersionUID = 1L;
	private int blogId;
	private String title;
	private String description;
	private String content;
	

	
}
