package com.crystalix007.letsmodreboot.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRamp extends ModelBase
{
  //fields
    ModelRenderer h15;
    ModelRenderer h14;
    ModelRenderer h13;
    ModelRenderer h12;
    ModelRenderer h11;
    ModelRenderer h10;
    ModelRenderer h9;
    ModelRenderer h8;
    ModelRenderer h7;
    ModelRenderer h6;
    ModelRenderer h5;
    ModelRenderer h4;
    ModelRenderer h3;
    ModelRenderer h2;
    ModelRenderer h1;
  
  public ModelRamp()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      h15 = new ModelRenderer(this, 0, 0);
      h15.addBox(0F, 0F, 0F, 1, 15, 16);
      h15.setRotationPoint(7F, 9F, -8F);
      h15.setTextureSize(64, 64);
      h15.mirror = true;
      setRotation(h15, 0F, 0F, 0F);
      h14 = new ModelRenderer(this, 0, 0);
      h14.addBox(0F, 0F, 0F, 1, 14, 16);
      h14.setRotationPoint(6F, 10F, -8F);
      h14.setTextureSize(64, 64);
      h14.mirror = true;
      setRotation(h14, 0F, 0F, 0F);
      h13 = new ModelRenderer(this, 0, 0);
      h13.addBox(0F, 0F, 0F, 1, 13, 16);
      h13.setRotationPoint(5F, 11F, -8F);
      h13.setTextureSize(64, 64);
      h13.mirror = true;
      setRotation(h13, 0F, 0F, 0F);
      h12 = new ModelRenderer(this, 0, 0);
      h12.addBox(0F, 0F, 0F, 1, 12, 16);
      h12.setRotationPoint(4F, 12F, -8F);
      h12.setTextureSize(64, 64);
      h12.mirror = true;
      setRotation(h12, 0F, 0F, 0F);
      h11 = new ModelRenderer(this, 0, 0);
      h11.addBox(0F, 0F, 0F, 1, 11, 16);
      h11.setRotationPoint(3F, 13F, -8F);
      h11.setTextureSize(64, 64);
      h11.mirror = true;
      setRotation(h11, 0F, 0F, 0F);
      h10 = new ModelRenderer(this, 0, 0);
      h10.addBox(0F, 0F, 0F, 1, 10, 16);
      h10.setRotationPoint(2F, 14F, -8F);
      h10.setTextureSize(64, 64);
      h10.mirror = true;
      setRotation(h10, 0F, 0F, 0F);
      h9 = new ModelRenderer(this, 0, 0);
      h9.addBox(0F, 0F, 0F, 1, 9, 16);
      h9.setRotationPoint(1F, 15F, -8F);
      h9.setTextureSize(64, 64);
      h9.mirror = true;
      setRotation(h9, 0F, 0F, 0F);
      h8 = new ModelRenderer(this, 0, 0);
      h8.addBox(0F, 0F, 0F, 1, 8, 16);
      h8.setRotationPoint(0F, 16F, -8F);
      h8.setTextureSize(64, 64);
      h8.mirror = true;
      setRotation(h8, 0F, 0F, 0F);
      h7 = new ModelRenderer(this, 0, 0);
      h7.addBox(0F, 0F, 0F, 1, 7, 16);
      h7.setRotationPoint(-1F, 17F, -8F);
      h7.setTextureSize(64, 64);
      h7.mirror = true;
      setRotation(h7, 0F, 0F, 0F);
      h6 = new ModelRenderer(this, 0, 0);
      h6.addBox(0F, 0F, 0F, 1, 6, 16);
      h6.setRotationPoint(-2F, 18F, -8F);
      h6.setTextureSize(64, 64);
      h6.mirror = true;
      setRotation(h6, 0F, 0F, 0F);
      h5 = new ModelRenderer(this, 0, 0);
      h5.addBox(0F, 0F, 0F, 1, 5, 16);
      h5.setRotationPoint(-3F, 19F, -8F);
      h5.setTextureSize(64, 64);
      h5.mirror = true;
      setRotation(h5, 0F, 0F, 0F);
      h4 = new ModelRenderer(this, 0, 0);
      h4.addBox(0F, 0F, 0F, 1, 4, 16);
      h4.setRotationPoint(-4F, 20F, -8F);
      h4.setTextureSize(64, 64);
      h4.mirror = true;
      setRotation(h4, 0F, 0F, 0F);
      h3 = new ModelRenderer(this, 0, 0);
      h3.addBox(0F, 0F, 0F, 1, 3, 16);
      h3.setRotationPoint(-5F, 21F, -8F);
      h3.setTextureSize(64, 64);
      h3.mirror = true;
      setRotation(h3, 0F, 0F, 0F);
      h2 = new ModelRenderer(this, 0, 0);
      h2.addBox(0F, 0F, 0F, 1, 2, 16);
      h2.setRotationPoint(-6F, 22F, -8F);
      h2.setTextureSize(64, 64);
      h2.mirror = true;
      setRotation(h2, 0F, 0F, 0F);
      h1 = new ModelRenderer(this, 0, 0);
      h1.addBox(0F, 0F, 0F, 1, 1, 16);
      h1.setRotationPoint(-7F, 23F, -8F);
      h1.setTextureSize(64, 64);
      h1.mirror = true;
      setRotation(h1, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    h15.render(f5);
    h14.render(f5);
    h13.render(f5);
    h12.render(f5);
    h11.render(f5);
    h10.render(f5);
    h9.render(f5);
    h8.render(f5);
    h7.render(f5);
    h6.render(f5);
    h5.render(f5);
    h4.render(f5);
    h3.render(f5);
    h2.render(f5);
    h1.render(f5);
  }

  public void renderModel(float f) {
    h15.render(f);
    h14.render(f);
    h13.render(f);
    h12.render(f);
    h11.render(f);
    h10.render(f);
    h9.render(f);
    h8.render(f);
    h7.render(f);
    h6.render(f);
    h5.render(f);
    h4.render(f);
    h3.render(f);
    h2.render(f);
    h1.render(f);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
}
