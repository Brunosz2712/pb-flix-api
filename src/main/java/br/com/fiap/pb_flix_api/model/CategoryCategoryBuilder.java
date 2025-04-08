package br.com.fiap.pb_flix_api.model;
import lombok.Generated;

@Generated
public class CategoryCategoryBuilder {
   @Generated
   private Long id;
   @Generated
   private String name;
   @Generated
   private String gender;
   @Generated
   private String icon;

   @Generated
   CategoryCategoryBuilder() {
   }

   @Generated
   public CategoryCategoryBuilder id(final Long id) {
      this.id = id;
      return this;
   }
   
   @Generated
   public CategoryCategoryBuilder name(final String name) {
      this.name = name;
      return this;
   }

   @Generated
   public CategoryCategoryBuilder id(final String gender) {
      this.gender = gender;
      return this;
   }

   @Generated
   public CategoryCategoryBuilder icon(final String icon) {
      this.icon = icon;
      return this;
   }

   @Generated
   public Category build() {
      return new Category(this.id, this.name,this.gender, this.icon);
   }

   @Generated
   public String toString() {
      String var10000 = String.valueOf(this.id);
      return "Category.CategoryBuilder(id=" + var10000 + ", name=" + this.name + ", gender=" + this.gender + ", icon=" + this.icon + ")";
   }
}
