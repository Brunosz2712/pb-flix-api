package br.com.fiap.pb_flix_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Generated;

@Entity
public class Category {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Long id;

    private @NotBlank(
        message = "Campo Obrigatório"
    ) String name;

    private @NotBlank(
        message = "Campo Obrigatório"
    ) @Pattern(
        regexp = "^[A-Z].*",
        message = "Deve Começar Com Maiúscula"
    ) String gender;

    private @NotBlank(
        message = "Campo Obrigatório"
    ) @Pattern(
        regexp = "^[A-Z].*",
        message = "Deve Começar Com Maiúscula"
    ) String icon;

    @Generated
   public static CategoryCategoryBuilder builder() {
      return new CategoryCategoryBuilder();
   }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public String getGender() {
        return this.gender;
    }

    @Generated
    public String getIcon() {
        return this.icon;
    }

    @Generated
    public void setId(final Long id) {
        this.id = id;
    }

    @Generated
    public void setName(final String name) {
        this.name = name;
    }

    @Generated
    public void setGender(final String gender) {
        this.gender = gender;
    }

    @Generated
    public void setIcon(final String icon) {
        this.icon = icon;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Category)) {
            return false;
        } else {
            Category other = (Category) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label47;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label47;
                    }

                    return false;
                }

                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
                    return false;
                }

                Object this$gender = this.getGender();
                Object other$gender = other.getGender();
                if (this$gender == null) {
                    if (other$gender != null) {
                        return false;
                    }
                } else if (!this$gender.equals(other$gender)) {
                    return false;
                }

                Object this$icon = this.getIcon();
                Object other$icon = other.getIcon();
                if (this$icon == null) {
                    if (other$icon != null) {
                        return false;
                    }
                } else if (!this$icon.equals(other$icon)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
   protected boolean canEqual(final Object other) {
      return other instanceof Category;
   }

   @Generated
   public int hashCode() {
      int PRIME = true;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());

      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());

      Object $gender = this.getGender();
      result = result * 59 + ($gender == null ? 43 : $gender.hashCode());

      Object $icon = this.getIcon();
      result = result * 59 + ($icon == null ? 43 : $icon.hashCode());
      return result;
   }

    @Generated
   public String toString() {
      String var10000 = String.valueOf(this.getId());
      return "Category(id=" + var10000 + ", name=" + this.getName() + ", gender=" + this.getGender() + ", icon=" + this.getIcon() + ")";
   }

   @Generated
   public Category() {
   }

   @Generated
   public Category(final Long id, final String name, final String gender, final String icon) {
      this.id = id;
      this.name = name;
      this.gender = gender;
      this.icon = icon;
   }
}
