package ajaxdemo.part06;

import java.util.List;

public class DiscussDTO {
   
   private int num;
   private String title;
   private String content;
   private List<CommentDTO> clist; //한개만 있지 않으므로 List로
   
   public List<CommentDTO> getClist() {
      return clist;
   }
   public void setClist(List<CommentDTO> clist) {
      this.clist = clist;
   }
   public int getNum() {
      return num;
   }
   public void setNum(int num) {
      this.num = num;
   }
   
   
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getContent() {
      return content;
   }
   public void setContent(String content) {
      this.content = content;
   }
   

}