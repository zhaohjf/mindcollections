package com;

/**
 * Created by zhaohongjie on 2020/5/12.
 */
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;


public class Base64Utils {
    /**
     * 图片转化成base64字符串
     * @param imgPath
     * @return
     */
    public static String GetImageStr(String imgPath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        String imgFile = imgPath;// 待处理的图片
        InputStream in = null;
        byte[] data = null;
        String encode = null; // 返回Base64编码过的字节数组字符串
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            // 读取图片字节数组
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            encode = encoder.encode(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return encode;
    }

    /**
     * base64字符串转化成图片
     *
     * @param imgData
     *            图片编码
     * @param imgFilePath
     *            存放到本地路径
     * @return
     * @throws IOException
     */
    @SuppressWarnings("finally")
    public static boolean GenerateImage(String imgData, String imgFilePath) throws IOException { // 对字节数组字符串进行Base64解码并生成图片
        if (imgData == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out = null;
        try {
            out = new FileOutputStream(imgFilePath);
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgData);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b);
            BufferedImage read = ImageIO.read(byteArrayInputStream);
            ImageIO.write(read, "jpg", new File("/Users/zhaohongjie/Downloads/21.jpg"));



            //out.write(b);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        // 测试从Base64编码转换为图片文件
        String strImge = "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0a\n" +
                "HBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIy\n" +
                "MjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAGVAQ4DASIA\n" +
                "AhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQA\n" +
                "AAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3\n" +
                "ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWm\n" +
                "p6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEA\n" +
                "AwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSEx\n" +
                "BhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElK\n" +
                "U1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3\n" +
                "uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDylVqR\n" +
                "VpypUqp7V6iR47kxFSnBaeqVKI+KohyIlSniM1IEx0qVU45FUiOZlfZinBas+WMdKAntTJlJ3IQu\n" +
                "aeExUyxgdRUgiyBTJ5mQBSe1PCZqcRYpwjoDmZD5Z9KUR1Y2cCjZSG5EISl2e1ThOKcEHpQK7K4T\n" +
                "2pfL71Z2UbR6UDuVdlL5dWdlGygEyts9qQx+1WSlJt46UCbK3l8dKDHx0qwU9KQrSC6sVDHntTDH\n" +
                "z0q4yelMKHFAcxVKe1MMZz0NW1GDVuLTr2e0a7itJnt0kWNpVQlQzdFz6nj8x61x1sU6c3Gx9nlP\n" +
                "C1LH4KOKqVuS7atZd7b3RjmIn+E/lTfKP90/lXRp4f1eTWDpC2E39oAE+Q2FbAGc8kDGPes50aN2\n" +
                "RwQykgg9iOtYfXX/ACnqQ4Iw83aOJv12Wz2e5mGNj/CfyqMxMf4W/Kuok8O6xH9lH9m3Dm6h8+AR\n" +
                "L5hePj5sLkgcjr61Yg8H+JLltsWh3+f9uIoPzbAo+ty/lJfCODirvFq3ov8A5I40wt/db8jURXmu\n" +
                "hubea0uJba4jaKaJijo3VSOCKxdta0avtL3Wx4me5NDK/Z8lTm579LbW833IFTpUypTlTpUypzXW\n" +
                "fMtkapUgTIqQJx0p6oaZDYwR8CpFSpPL6VKsfFUQ2RbMilEYqwI805YsHNFxNkAjqQJgDirAiFOE\n" +
                "VFxEIjz2pwiqwq9sU8Rmi5Vyr5dAiq1s9qNntRcVyuEpwT2qbZTtntTFzEAQUeUc1YCUpXBpXHcr\n" +
                "eVTvLFWAmaNlK4rlUx+1N8urZXtik8s4ouFypsNIU96tFPWmFPamFyts4phSrZT2ppSkK5RdNuDX\n" +
                "pXws1KxtSbFZr6W+vJjutlTMMSKM+b7Z+6TnrjivOrlcKv1ruvh5qV/F9nstL0fmW+UXuohC2IR8\n" +
                "2wnoDjP59M815eI/js/Tsth7ThqK831S6v8Aqy1Z12jiC01XR5buxhuNXv7i8jmv2G2RfLLYxx02\n" +
                "gDHGBXG+Jzoy6V4d1mPQ7aCO4uZjcwQnb5qq2MFsDrj8M12mi3fiZvFsls+nIugC4nKTmNckEsQQ\n" +
                "d2eT7VieMzrttY+GtQubSGW7hu5Fa1EYZS7E7AAOoKg++fesXrEjBtwxcU2rvtLo1LTTbovL5m7s\n" +
                "tbh/C93a6TqEMYtkaCW0O4RIyr+5k5+6RyW/2fetP/iWvLaj+1p7lvOuvKgM+RO3O6M9N2zJAGeM\n" +
                "e1ZqalqTeKfCcVy8kH2qwlkurZQUXzNinBX2Pr0rUtBdFNN3tekmeTzS9lGpI5xvx9wehHJqzy66\n" +
                "klFt9HbXzl/keD6/apZa7eW8a3YRX+X7Ym2XkA/MPzx7YrnildF4iuJrrxHqks8jSSfa5V3McnAY\n" +
                "gD8AAPwrGMdaYPqdfGPN7LC82/K//bSJE5GKmVOelPROlTKlehc+C5iILT1T2qUJUgTjmqIbGBOa\n" +
                "eE9qkVQelSrHTJbIlT2qUR8c1KEp4TNK4rkQj9qcE9qnCc04Ic9KBXIQg9Keqe1TrHTtlA7lcpzR\n" +
                "5dWNlL5dAtyqI/anbcCr1pai5vYYC4j8xwm4jpk4zW/qPgXVrJDIgS5Qcny+uPpSc0nZsuFOc4uU\n" +
                "Uc3ZaXe6gZBaWzzCNcvs/hqB4mikMTqyuvVWXBFdd4Cle38TiEEqJoyrj1I//VTviRPaQ6npzGIL\n" +
                "LPKYC44ye2fyrN1bT5Wbww/NQdSO6OPCUoSpgoAJzwOtLjK5Ugj1rU5b6XICnoKTZ7VaKcDIwfSk\n" +
                "2UrhcqlPameX7Vc2U0pRcZT2c9KayVcKe1MKU7iMm+XbHGf9o/ypbDWtU0uOWOwv7i1SXlxC5XJ9\n" +
                "a0pLaOUDegYDpmoTZwA/6pf1rhrYeVSbkmfeZJxTgsDl8cJXpuVm+ia1d+rKY1nVVt0t11O9WFF2\n" +
                "rGtw4UD0wDSLrGpJbJbLfTiFJhcKm/gSDo3rkYFXPsUH/PIfrTGs4f8AnmP1rL6pPv8Amer/AK7Z\n" +
                "X/z4l90f8xp8R6y2pR6i2p3L3kalEmZ8sqnqB2A5NNh8QazBOs8Wq3qyKcg+ex5+h4/SlNrF/wA8\n" +
                "xTDbR/3BR9Un3/MP9c8rtb6u+20dvvKUskk8zyyuXkkYu7HqWJyT+ZpCnNWzbrn7oprR1tQpOne7\n" +
                "PnOI88oZq6fsIuKhfe3W21m+xAE6cVOkfSnCPpUyxnFdVz5VsjEdSLHmpVjPepVjp3JIljA6DFSB\n" +
                "KlVKfsoRD0RGI6esdSBKeENMlyIwlPCVMqU9UpNiTI1WnbBUyrjFSbahs2iV/LAHJx60bVA5IGR3\n" +
                "q0mY3WQcbSCBjOTS6p8TbPw+XF94Y3Srjy54xlH/AB6A+1ROo46nRRoqq7XsyfTtGv7u6t2gtZSo\n" +
                "kUmQoQAM9a9R1C9ext4lTa8jELzXgd38U/Guvy7NE0s2sHZmT+vSvZr7MegWE0wCz+TvkIPQhMn9\n" +
                "a5qk3LVo9XDUYUbpO7OG8Na/BqHxSvYUjQC3lwGjHByvP61W+JNxpFx4p0nT9S1B7SRLhpVxCXVg\n" +
                "Cepzx1rC+F8IGpzamMtJdai5znquTWp47tYrr4vWsc9v5qraOQCpIJyMUNN8tyYSjFVLLYnn8aeC\n" +
                "vDETOu3ULgtnLNvP0AHSsKf4mW/iTUUtbTw48a5A8+FfmH146Vtw+GY4QJo9EEfOd4hJz+faniMR\n" +
                "k4QIOhAUD861tLmvc5PbU1T5OQrmLBI5z70COrO3HHpSba1uzjtHoVygFNMeatbM0eXmjmDlRT8r\n" +
                "immLmrvl0eXScyo0rlExDtTTD7VeMdN8up9oaewKPl4ppiz2q8UphSlzlKiigYajaLFaBjqNo80u\n" +
                "dl+yRntHUTR1oNHUbR0ucaporLHUyxcdKkVOOlTLHVc5HskQiIVKsVTLGfSnhDnpRzsmVNIjWMU4\n" +
                "oPSpvLxSiPB6GtIyOacehCI+KesXtVhIiRmniOq5jJU76kAjqQJxUwj5xiniPB6UuYrlREqcU/y6\n" +
                "lVB60/YRx3pXKK3l5Ppk45rV0zw+datpSJbdY4z8yzLuH1qkEx26c1rRahH4d8H6nrE6B41HzLxz\n" +
                "joPxqKkrRNsNT9pVUZFHUtIfSysfnwyAjI8kYAH0rp/Fdylp4VMknSOyck/VCB+tePeA/DWueI7p\n" +
                "/FFxeXEcG9wkEjMAwOcAA9Rz2r1P4isIvAV6JflYWWCPwrCc3JK56mHpKnVko7HA/DCLZoOjyd3m\n" +
                "Zzn/AHjWx4u1PU9N+K6f2d5e+SxchJVBVyCvc9KPA9skWl6CqABfLQ/mMmpfEOmXuo/F+2kt/KeO\n" +
                "K0f5S4zyR2NVJq8TCjJ8tRruc5d+KPihdTbYbS2towedrqQR+JrS08apJA76x9m+0k5PkZx+P/1q\n" +
                "6seFtSKA+VGBnoXH+NJN4a1KBPMMCyKB/wAsznFXFxjszmre3qL3oaGAUOemKAnNXGhKsysrAr1z\n" +
                "2pPL/H/CtOY40mVRHzRsq4IxjnI+lNMfoKTdzRJpFby6NlWPLIHQ0mys5G1ORXMWe1NMftVvZSFP\n" +
                "asrnXFFEx+1NMdXTHUZjpXKsUzHUbR1dMdMMftRcLFExZqJ4+elX2jqIx0XCxXRPapVj9KeqVMqU\n" +
                "7iIxHUyIM9KesdSpFmmpGckR+V6Cr0GwKFIUr6beaIlTOHB/KreIQAFB3UOXQUIW1uMis4pmJVNv\n" +
                "4099LG75etKY55PlJyOvFS27vCcSS4H92ovJapmqVN6Sj8yq2neW43AY9avxaLFKmQ4z7GpTOsxA\n" +
                "yMe61KLwQjCRg+4GKmU6jWm5pClh07vVEH9kIvHktx/FmpY9CR1xk5q1Hfl0OXCn3pGvZVHysjCs\n" +
                "+atsbezwq1aEXQ4QPnYcDsKu3v2CLR1tWsre5tMbphKBsGO7Z9KzzqUi4zGM9c5rlPHOlX/irSfs\n" +
                "thqElm+fmVGKxSqeoaqgqn2tQ9rhofBoc34k+I1xrepDw14RXGDsN5EvyqPSNegHvxXSfEq+SH4e\n" +
                "X6TXBe7MEVt5ZOSG+Ulifel8L+GrPwvYhLVFa6ZR51wFwW+noKf4j0GHxDpgtJAqukqSqx6nBBIP\n" +
                "scVpyMyeMhzWRo+FLBIrHRB5oysMRxj/AGRXL6/bpqXxuvIHlmi8rTyfMhbayklefeu1sH+zX1q2\n" +
                "MRoQoX0GMVxVqWvvjP4juSMrBbCHd+X+FU07mdOcVSm4qxXuPD/jHT5hLo/iszgciO8TH4cZpzeO\n" +
                "PH+jzKl34dFyFXJlglO1/wAK7TZkZ9aVUZOVOO3FPlRnHGVFurnI+HfFmt+KNUuTqmiGzRVzFIBg\n" +
                "DHUH1rpFiBHJwKtspYYLMwHQdqTZ7/l0qk7Kxz1Jc8uaxXMaquAQTTdqY+4M1ZMfHSk8vPai4mVh\n" +
                "tU52Aj0p29QciFfxqXy6Qx0m0yo3uQPlznAH0pmzFWvLo2VlJnXBNoqbKjaOrpjxTClRc1sUTHUZ\n" +
                "T3q80dRNHRcdikyccVGUq6UqMx+1FwSK6x1KkVSpHxUqx+1HMLlI1jqRUIqZUqQJQpEyiRc+9OXI\n" +
                "PFSCP2qQJz0rVSOWUXcYjMvXoe1B3N9KmCU4JT0IfNaxHGSnQKalaaR1APb0pQlOCGh2e47ySsiI\n" +
                "An60oTJqZY6kCUXFylcJ6jNKI6s+WD2NOEftRzAoFby+ntRsx2q15dAjo5gcCtt596zNO0CHTta1\n" +
                "LUomz9vKll/ukDn863RHnqM04Q55IGaTkhxi1sVvLwAKNhq35R/u0nlH0pcwcjKvl+1IYzngVd8o\n" +
                "46Unk0cw+RlPy/bigx1c8rHFJ5VJzGqZT8qmmPnpV8RZ7Uhi9qlzNYUrlAx0nlZPSrxix2phj9qy\n" +
                "c7nXCnZFMxjsKYY6vbFHamlEz0qeY05TPKc1E0daDovUComSnzC5SgY6jaOrzJUTJRcViJYT6VKs\n" +
                "ZFTLET0apkgz1ao5zX2bIFQVII6tLbZ6GpRaNjpmlzoPYyfQpCP608Rn0q0IcU4RGrVQxlRZWEee\n" +
                "1PEY9KsLHTxH7VXtDN0CuI6UR1ZCegp4j74o9oT9XbKqxc81IIhmrIj9qcIz6UvalLDMrCOnCMVY\n" +
                "8v2p3l8dKXtClhyr5WKcsRbopP0FWPLz0FX9NXDyd+KcZ3dg+rmQYiOqkUeXjPb1rn/Gnjm40G90\n" +
                "yNbJbhLy7EHljOQOmR711TIASM554OOtOcuUPq6KwQ9jS+XVkRkj29qPL9qn2iH9XZX8ujZVrZxS\n" +
                "eXS9oV9XsVtlJsxVry6Ty/al7QaoFbZmkKVa8umlM1LmbRpWKuzimMlXCmO1MKZ7VHMachTKUwp7\n" +
                "1cMdRmPinzC5CmyVGyVdMdRNHT5g5CkyVEU5q86VEyGjmFyCeWAeBipFjzSKCetSop4rO5tZD1jO\n" +
                "eMVKobpTVDetTIpJ60m2UklsOVEZsnp6U792WIwKQRmnhPakD9BmwbuBUixpnmnqnFSLHT5ieQiM\n" +
                "afwmgJVgJg8CnbM9qSkPkRXEdTLDkZzTtgzT9vtQ5MaghggFHlfSpfwpxU4GRSu2JpEMgt4bIzzM\n" +
                "UA6t6UaXeWt1HLJa3EU0YBy0bAgH3xWN41l1JfCtzHpelyahcTAxCJMAjcMZ5+tZvw78Mt4W8EW9\n" +
                "nfBba7mJkugG5yT0/LiuyEVaMkYvqc/4m8ex+HfEVpYtoY1WQq1wNsYeSI56r+FJc/HPRI9PeVoJ\n" +
                "Y7kLu+zyxFXY+npWjDpvhnQPF9x4o1DXzcXZTbEjYVYVxjHB5rJ1/wCJPw3mfE+nWmoyKeGFurHP\n" +
                "1PWt2ruzWhB3PhbXovFOgQarDaT2qyk4jmABx6/Q1s+XXGeHPih4Y1Ow2RbbFIPlSCZfL2qOgXtV\n" +
                "u9+J/hCyRjLqUJI4IU5NcroSb0NYzWzOp2UhSsrQPFmheJ0dtIv47hkGXRc7l+vFbRFc7unZmiaZ\n" +
                "F5dJ5dS4oxSux2RF5dNMdT4ppFK41YgKY7UhT2qemkUXHZFZo/amNHVogUwqDT5h8pTKVGye1XWT\n" +
                "FRMtHMHIUmSomSrjLUTLVXFyDBbtUqwkChG6ZqwtY8zN/Zx6EaRmpljxSr1qQUczFypCLHin7KcC\n" +
                "KcMUrsgQJTgtO3e1OBGOlO5NxuKcBQOeRj61j61rQtYJIrQhrk8AkZC1E6saa5pMdOEqsuWKNZ9k\n" +
                "aF5GCoOrMcCs+DxDo1xK8MWpW7SL1Xd0ri7q61a4sEtJbl5MD5pJOAaylsLbT3eeQs7KN2QMgCuG\n" +
                "eYpO0Vc9ajlUZQbqz16WPVIr6ylO1LyFifRqNavn0/TpJIgHdIWkVT/EQM49q8x0/UrWaUNZFS6O\n" +
                "Dhh0P0qD4j/EFLDSPs1ss39q3CeUFdMAA8ErXo5diVVlKE1Znn5hgnQSlF3RseIdW8aatFYz+ELe\n" +
                "B7G8iDfaJJN3lnOCMdgMVy974F+KWpTSR32u2tvb5GZEnKhh7ViaLPq+gaJZw3FzNEEQsVzwucnH\n" +
                "65r17xL9uv8AwMq6aC9/Jbq0TD72eM4rpoYl1HKEehOLy54anTqTlpL8DjdI+Begyqp1jUbu9uTl\n" +
                "ndG2K305NdTp/wAPfAmgXEUUOn20kzNsQ3R8wluuBnvxXOeEfCPiPRNSXWbi7kmuWh2GO6udq884\n" +
                "x25rnfF+raxe+KNI0uW1WAW92txLPbS+aAecZIHXBNbe0U6bb0/A5p4aUJqMWpX7a/eevax4T0LX\n" +
                "dNbT7/TIGhPTy1ClT6g9jXM23wV8E2x3fYLiXviScn+ldhb67pt2GeK8jHPSTgirI1C0Z8C5hJ9m\n" +
                "rzliJdJDdCS0cX9xW0nQNI0GDytL063tEIwxiQAt9a08c54qs97bIu5riIAdSWxUkNzFcJuglSRP\n" +
                "9g5o9rfdi5GlexKRRtFNyc+vtRye2PfFPmFcXFIRxUb3EMYO6VBjrzzVN9asVOPOYkei5pOpFbs0\n" +
                "jTnL4VcvbaQiqY1ixIz9oVf94YqxHMk0fmRMHX+8DQqkXsxuMo/ErCkU3FOLexpjuEGSQo9WOKdx\n" +
                "oRhUbLmq8+p28QO1t59qzJ9VlkHyDaDWM8TCPU6adCpLoaj7QeWAPpmozj+8K52WUl9x5PrmoSWZ\n" +
                "f9Yy8+tc/wBf8jrWButWdMgz3qYVVW6g7yr+dP8AtlsOswrq549zncJdi2tSA47VQOqWaDJmz9FJ\n" +
                "qM65aEEJucjsFNRKvTjuyfZVHsjW/DFQ3V/Z2MfmXV1FCnqzAVkzav5sZC5VsVzt9EL4hWJLk/fP\n" +
                "O36Cuapj4r4dTajgXN++7I17z4j+GbDIe7klb0iiLZrW0/xVo+pWpntrxSB1jcbXH1BrgT4ft1ka\n" +
                "byFZsfKAMY+tUmsjZXKTtCdu8DC+n4VH197Jand/ZeGkvdkz0i51uN/ljlREYeuSazkNickyFq58\n" +
                "3dsSyvlSoyXx19hUbX0IhLJG7kHALMBiuSpXlN+8OngVFWhc3ryGyYK5k2r6NWZcwRSRtFGxZGGM\n" +
                "ZrIlv3YEtglemTxUsUjToqljzyNvFYSnfU7IYaVNayJJo5baCNbIrG4YAnA/dKO49TWBfapp+oah\n" +
                "Ams2eWjb/R5pF4B/pWxKI4UYFpGx1x2qCDR01B/KdSFYFlLjIranVS1afyNfZQcW5v8AAyNV854G\n" +
                "WKVJ4mGSHPBB4606fWdR1XwRJ4atrC+uLhdi2s9upJU7wSGI6DHeu88DeHWtL3UhcTxS2rRLsj25\n" +
                "EZz15rk9e8VeL49UurDSbSCOO3k2+buUKR17c9K9rApUaaq82j+R5+OxFLFc2FUbtap/8BJnSeLf\n" +
                "At1qekaa9trp0m8jt0S7Bf5X4APfrmsrwf8AD3TVvLmCTxLcXt/CMuUGEA9s9frU3xbmuj8PrF8h\n" +
                "JrsRRykN3OM49s1m/DDTYND8UJFFLNLcSQMk7uSwHTOPbNehiJU7xhLXmPGwca7hOcHrDqaev2Me\n" +
                "jaklss7T+YhZSy4PHWqYuCSGcAEdMVg+LdZbVPiVb2VuXZNPhdZSMkgnGf5VrWw87a0iSgDoAhxX\n" +
                "g5hhlRrWg7I+hy3EPEYZTqbrT1LkV4ASWCntkEmqH9pzWl6vkbih5GW+bd7e1aFokFmoaOFn2njI\n" +
                "6n1qJo4p7oTSxlWB+UEcCuNSad7nYlB3utDpbXX78wKJ7mTdjnjmpRrF8d3lzyFT/fNYZ1C1g+Rn\n" +
                "LSdAApqZdSDLlI246/KaftKj6nnywkb3UDTVriQ5crz1NKVkBOApx0FZX9oMzgBZM+ynFTRSXby5\n" +
                "ZCEB9etS5MHRkuyLEiMwycA+w6VRN1dWlwJbaR0kH8QPB/CppZJtx29KqSCc5LVKqOLujSnBNWla\n" +
                "xfXxRfYImuBn/YFZ8utSM5fczsf7xrOa3m80kKcVDMCgIwc1Mq1ST1Z1U8JQT91Ivtrc6A/dJ/lS\n" +
                "2PiEN+7vcK5+7IowDWSU3nBHHpVd4GDEc89KqEujOj6pRkrbHYC6hb5hKjKe2aVZVckghvoa5JbO\n" +
                "VV81VJHQitBDcQoAuQMdqUnbY55YWK2kbq+T135/4FUgkjxgAEfWsqOGMqSGzlqmGEwATtNdMqUY\n" +
                "bnKkplz7ZCshQxhSBnNQX8Ul4kcdrNJanO5pExyO4rm9Q8RNaajJAbdWVOrZ5Iq2da8+zW5tCZVV\n" +
                "h5i9Cgrb6u42lbczThJtJ6o3Ua6iTj98hYBQ2AVX196lEpVwNpJx1rNS7lNv5u7dkbkA709JpGUE\n" +
                "sQxHIHODWTS6o19kaDTlyMqcGoi0n3UTI96jZJHKhJ2U+wrM1PUrrSZYhKySxyZwyjDCqjSU3aO5\n" +
                "DcYK7Ll0ry4H2QqMc4NQO37tY2tP+BVYsZ3v7SOdJTtbqO4qvqc11YosySI8RbbtdeR+NSqKcuW2\n" +
                "pqqqitRu2dV+W1gJPUNmpgZlyViUD2pljqsFwMSTJG/91q0GQgqwbg9D2qZUnHRoarJ7Ge7SFTjt\n" +
                "zjb1pVmuSQVLDHAAA4q+LcnkuKlS3JX5SD61Kgl0G6sbbC6Jq39jtcTXpZoJFw20frXDeH9Qg1PX\n" +
                "fEt1a3HnWktwNgcHnCjnnp0xXZ3NqywExMpYEYB/Ws7+zU0qzuZ7C2to/My8yEY3HHbiu+Fb/Z3h\n" +
                "2t9jglRi8QsQvn+gnxemlPg/w7AnPnXUSkYHb/8AVW1Z6tFoFlqM7BcpCxVxHzn06VzPxMvkuNK8\n" +
                "FYcAvOsmPTAOa1XvIXSRmuo2XJDKe4Nd2LnOnKlKK2RwYOlGrCrBvRs474dxSy2+o+IJwon1GZvm\n" +
                "cZ2rnnrzzXYFjGoWW7DAjICjGKLG3gS0ENsIxAvChRwPwpRbNuCNt3KRg47V5teTrVXN6HrYWlGh\n" +
                "SUF0HJEkwDq2R7mn+QN4/dbvzqK0Ia4kty3zRdQB1rWWFsBlY1zSp2ZcqlupRa33OAkSoT3IqeG2\n" +
                "nCHkfkKnhjlMpOcgUkZeSRwGACtilytmcqjehE0EyAESEE/7NUp3eLBkuG64rXbcBncDt6VlyxNN\n" +
                "DKbgJgHK4JoUL7jpz7kaxyy/Mku4HpUollRxGcEjviobN0eRoEyrw/eAPXNWTGCV3OASccU3Tsau\n" +
                "Se40mbdygwfammAuMvCtTujRrjeaRVkZcmQe1TyLsSpdUUmssHcIhUM0UcABkTDNwK1CGzgPVTUb\n" +
                "aO5CRzOwwMgqcYNOMI31LVWRWNtOQVVtq96QafKefObJqhb69AJDHPMUIbZk85+tbEUhVflcEdRj\n" +
                "kYq5UXH4kVGs5fCZyWSrIriR9ynccNVo3Bjhlkx8yqzAHvgVnJdQRhmiik3N1bZkmq95rMFum2eG\n" +
                "UK4OGK8H8a3lz1JJWJUYU4Nt2OPlupLmdppCCxJz2710Xhm8UtNbhAzOhYnuT0H4c1SefTLraqKT\n" +
                "IOAQuNv+NXtMm/sy9+z3ECrvAEcw6MPeu+tLmp2tZnn0IctXm5ro17afbZKisPkYpgdj6VbSQ7mA\n" +
                "P3Tg1Vmjkt7lniiLKRl0UffHqPcVYt5VuYhIvQHBOK8uS0utj1Yy6GlayfMd/Q1j+Krcy6atwrZN\n" +
                "u2fwPFbC7dvTp+lV5oo7qN4pFyrDBWinPkmpHPUpqaaPP4LyeEgxSuh6kq2KtSaxezwGGa4Z0znD\n" +
                "c81rXPhNXnLWlyI426pIucVEvhK8XJ+0xD0I5/SvV9vQerPM9hWjoYonYnIbI/lXSaBqMji4iluD\n" +
                "sAGzzG/lTx4TtjCu+4l88dXVePypLfRrawvlaRJrgAgJuTCg+prKrWpVItI2o0asJp2OjR2CgE9q\n" +
                "nhkdQecZFZyXAVkDjahbAbsPar6Z3bfSvMd0ds0SqSMliaoXE3nxyxHO07hz24q6zMGI4qu8LDc6\n" +
                "oGbHT1qkTFLqea63/aOpappBuHIg08MqhxggEnp61Z84ls8HJ44rsZrOHV49lxBJFKnHzDBH09RW\n" +
                "Xe+FbmCMNaubgZwVxgge1erHFRnZT0Z50sN7Ntw2ZX0bV106ZvNRmjc847GusMglw8TAxv8AxDtW\n" +
                "BF4YjMKs80sb+jDAz6VvWkEVtbxwRAKuOOetceIlTk+aO510VOOkiSGPZK4OAT/F3NXLeYmN4z1U\n" +
                "9aqlXY5XJI6GpdkiIWx3rlbuaTSe5bSdV6dajkJL8DGeetM4QZVsn0prM2Rg0jNR10JTMqjD9KzL\n" +
                "m4SGynmL/dyVHrVjzE8wpJIM+lVrhYGPVWHQg000tzWELGfbypGr3abzPNjYCT0Pt6VooxeXJ4Ve\n" +
                "3rTNyH5ht3Ac4HanCdDyvIx0Apylc1sTTyEjrwKakvftilJGw5ziljAxgDgVFydEhBIC445qreOW\n" +
                "bGelXSyZ4FV5pY15JwB1JpplQet7HmlyVW7mRgcbz+Ndf4akkbSv3rgqHIQY5A96tXFlZ3H74RxN\n" +
                "u5Bx1qSCJ4xkFEB6r2zXXWxKqU+W1mY0sM4Tc76GLcXaW1zuwPJYjbIf4WqxL9kkuBbSBDHKAVV+\n" +
                "/qRWLBFMts8Mj+aGXAz1B9j0q0Y5pUtyhIkjwCT1ApuKT3LTbRYuNBsTE3lRu75yo3YxXM3MtzZX\n" +
                "DQFpFAPyrIc/lXX7wJApzgDkioprW1uUUzruZeASORRRxDg/3mqIr4SM1+7dmZel+JJhPHFeuhhC\n" +
                "48wjDA9hnvW1G00V/HJDgo5y6gY3A9fxFZDaAkMgnt7ldqnLRuuQRWjFeWqQZXIHT5VIp1nTl71P\n" +
                "5hQhVirVehvLcow+X5lFDXEUWBxuJxVKAlgGG0xtzgD5jSNGYpXeOJpJGIJJPT6Vx8utjrsjSMkQ\n" +
                "PI5HFSCaPPTtWYqOhwdzHPPHFKX/AHnl7H4PXHWpD2aZqmeBVy4yfrVS6cuoMOAQQTu7j2qryCRh\n" +
                "jzxTxGMMrO3zKF69Md6adhezUdiSO4QD7pKOdu0irC3WYl8jgc496zLMsImjlZ9yNw/qKtyCGRCp\n" +
                "DKMjkdqcmkwcE+hJJqJt186SKU7RysabiTVIeLrVrkRGK4RmOMuu2pvJzMpjJlkPCjOA2fWtWLwf\n" +
                "eXMISS1hRDziSQGt6NNT2i5ehy13CFryS9SBpVlTBIKnuOv51Smlv7SFjaTfaOeI5jyB7Guii8N6\n" +
                "fpdttvdTht416iPgD8TWa+teBRex2x11WcsFGJBgn61vHAYjtp5nJLMMLte/oUnli1O3WO5RgwOd\n" +
                "jcFT6imW9m0Nxvgkk2Z5VznNdRd+DGi/0m2kNzGnzopPzf8A165O+1SB7vypZ1gkR8eXuAJI7f8A\n" +
                "1qwq06tOXI0dNCtRqrmpu5cYTb/9aRgccVJGJm/5an8qrQ6hG5bYWLK21lI6GtC0vUaMMOc5HT0r\n" +
                "ke50TulsQsJ0U4mxjvig/aGAJnP5VHcXiuCCxwW4AHU0+0u0kkKq2Sn3hRe4WklewbJery8+uKYA\n" +
                "xb/WDGe4q3NeR9Scge1Q/a4ZiF4DAZ6UuYSct7DViIJ2yDP0pu11bO4E96eZlVs7RimGdBkEYHXN\n" +
                "O7KXMRm4mVwAEZehpVumQ42UySXEqlVzx2pq3inBTa65xkUXNOVdiyJ2ZflAqszzMzZ2gY6+lSxz\n" +
                "eqgD2qKaVQc4IGcUJhFWexCUcdxgCgAkcEYqXeM/d3VFv2kjYTz0x0o3NU2YwSNI2cOGVcfLjnmp\n" +
                "V8oMuOCewrPtY4omIZ5M8gk4yD7Vat2iiZNpfPcuASa6ZW7nNFPQvmNV6kdO3apFjAPG05GRmqnm\n" +
                "xyOz7GfA6Y4FPR4+pJ9vasnZGiRYE9ps8ximMf3T0p0UtkwbYyjA5BQ9qpyWtrKyMxJMZJCgkD5q\n" +
                "lWKBW27uVOMnOV9qTcbaNjtLqTXGo2tjCJSWcHosaEmoV8S6eeHkKHg4dSKpy3kEMypJHJF8xUOx\n" +
                "GH/wqHbZXEj77R3w23nGCPatY04W95Mxm5N+4dOkqSyAKVBI3Z5wR7etSM5jiLupxuwNozWTDNDb\n" +
                "7FjJROwOTt+lSzXBKkvKxUf3BjP1rBpJ6FqDdrl1r6FU+VgWHYioTdSOoIZBn2qmWCLkR44zz0Jq\n" +
                "RVURO7bgQMlD2+lS4to1SpoYbi5Qs3nJt7cVYhvXFzD5rIU3ruGOoqnviKh23LGRknAwp7D61KLd\n" +
                "Hi8wkocZIPUYq7tWbKfI0dz4j8OiG3GoaeFjCqGeL1GOory3VtP8Q31w5svFE0ELHPkyKfl9gcV7\n" +
                "Pqs0a+H4mnDPG0DB9pwdu3nFeX2njn4cWtqpaSdpE4KThi2QfavoKuFqRmqmH0vufLUcZSnB0cUm\n" +
                "7bdzk4vhxqeolpL3XLudc5by1cg1p2Xw90SwGJLZ55vvbrg4I/AYq1qfxrvJHW18LaMzjOFcxZB+\n" +
                "mP60+w13xprtyh1vR4Y7fvNgIy/h3rHFxrwpc3tde2xpg50JVeX2Vl3ep7PZ3aQeG7a5UbgIVCr7\n" +
                "+leQ+Or+1vfGkFkkawXMtr5jMgB+n416VpkrSeDEDDLAlB+FeLQRjWPiV4g1JRuFq3lR5PFdVWcX\n" +
                "g/aS7J/M5cLCUMdyR7tfIfFLqUsMllJIYtRj+aN+Nsq+ldFp0jyKXJ2uUG+PuG6EmsbUktGgdZbq\n" +
                "NQpzuWT50btjFN8P3sJYFp1kunG2RyTk88V4lSPPT5krfI+jjJRnyc1/6/M2r+Of7JiJgshYHI7V\n" +
                "LbRSfaxNv24j2sP7x9afND5g2Mw+c4HNTrZSwwY3KfcGuNN8trHTJxtZsrz+b5EgX7xXAz60yAuo\n" +
                "Ab5mwASKleCVl69KRbaXJZR9am+li04pasSTzDE4GcnODTHLGEBl+U8NmpvImPGD+dMeGYryMikm\n" +
                "2gTRnWt1N9rubUqQkLDy3wfmB+tOiaSC8+zeWBauhYMP4Wzz+dLPDL9oErbiCOEpZS21VdsBvmXk\n" +
                "VtzdUtxJK1myxE8whcMB8pwvvVe4cloywOQeG9DVjcwCgKenpUErSFenH0qFuXZWKEeoXAuIbdYA\n" +
                "N0zJICT8vTDD2rRklbaoLDI6nPWqEok4Kko4Od5H3hVqORLhd4yfbjitZ2snYyjdMxY54ZMqEYMO\n" +
                "oJ61aSdUdHXd5YILLjJb/wCtWZf39uJv+JeojUDln5z9KrLqUiOCr/MOpHevQ+qSep531yEdGdGZ\n" +
                "lRJVVXVc7s9Qc1KkiFN8qNyvDAf0rCttcniJRgGjbnI7GtP+0kjsVk3LIx7Hk1lPCyRrDEwl1L6X\n" +
                "cJTG1l6HOMg/nTfOR/NDbhyTgdh9axhql1JKCiR7eoXHapP7QuoUJaNUX0JzS+qSQ/rUCa7iedRM\n" +
                "FEjKNo8wcMvcfj60I26IBi0TsMoGGSuO1VV1S4dcM4yRx8vAqVtQmV1DpGFU4UsMZNaKjJLlZEq8\n" +
                "JPmL6eYxIuDwwAG3sKlMrMkckMsckYJDYJzjoKprrESbd9nvJB3YPAqj/ab/AGsy21kkRP3vmyD9\n" +
                "RUfVJsr65BdTfbZOyoxPC5DY6GntIJ/LkYsZAChdegHqR71jDX7nOGjRSDwETP51Wu7q4uys5laG\n" +
                "XP7vBwpP0pLCSvqKWKi9UbcZU2kMySK6ElSuOnqaleWOSJWhlBBBRWB4bNc1DqN3b3HnbAs/93+B\n" +
                "89sdq0tIuFubtIltBDulw0ZOcMeuPaiphWldFUsUpuzPV/EkttbeGovtkjxW62rebIgyUUpgsB7V\n" +
                "zGn/AAx0Kx8N206CPVYUj85XliVWdT82cj2NX/irN9m8DXyg7cWqr19eKn8C6lGfh5p0EjEywIsb\n" +
                "c84I/wADX0E4xkowlv8A5HylOc4uVWGy3+bOWs/iF4Z0vULaz0rSCJJJREWigOVB47ivSNev7HTr\n" +
                "eQ3EEGyOMu8jgAJgfzrzuy1Xwha3N2114gd2t7hwwZdjA5JwCOoFYXjrVNB8YWSWmm+Mgr5+a3lX\n" +
                "5Jee7duKyw6cVKNSOi/rokbYlJuMqTd36/nc7/wTrlv4l8EPdWyvEouZAFbnGOleYeC4H/s3U5pQ\n" +
                "WmubuRWb6f8A669M+H1nbaX4NlsLUExROTux94kHJrzjwq3+g6jGjYC6jLgn04rjxk08EnDa6O7A\n" +
                "U5Rx7jU3Idb8OxvJCbK3VCSfMYnk+9c68EtpN+7fJXoyZG3613E2pLZjbcoygEIG+9uB71PItqZH\n" +
                "AjBLKAzbc5B6fWuCljJwilJXR6tbARqSbjozkbLxHe2rjzgLiIfwOMH866ey8TWN64jDG3lOAFfu\n" +
                "fbFRz2FkVCTwgh/k3hQCKo3PhazGJLG6nhlU5HGcfjSnUwtbWSsxQo4qk1Z8yOnWSQyFAQXX7y57\n" +
                "etWo2IicjrjoK5SHV30//R79m8/HEx43ita31WGVYxb3KSEjs3J+tckqUo62uu52JxntubPliQBl\n" +
                "Y4A61FIku1wGwGXB5qit05OTJ8o9Oajur8xKXCglhjBOM1nHVj9lJBLFAXVnd8Z8ojccg+1Vb20+\n" +
                "y3CuqecyDIkZjtC5547GmtrSxWjyYQOq8pjk/Q1TfXlIUrGgDJ8w/Doa6oU59jKbS3NhXDxqVmLI\n" +
                "5yrjtUpxuA3ZIGQxOM1yL63LbuohVVhXhkx1HtUc/iOSQ5gPy9sjpV/U5sj65GK1Ny8mhV/MkkY4\n" +
                "JGzPaqkms20AARdoPauWutSlaTPc+gqo8xZuSSfQnpXbTwKt7xxVMc/so0I4ZLli4U9cc1pf2csY\n" +
                "TKHcwAUe5P61atrIGMXFyh8tuY4uhfHc+laz2U16v7lhGrAbfbB6e59qqpXd7IxhRVrswJrH7LIo\n" +
                "diGAORjGD9KW3sD5LzBGVV6sfumtpNNsLe4aCVPMmAySzcbjUt+wtdgSC3jUDKgLkN9Bnis3X6Fq\n" +
                "itzGtisBZmUNIwwijtUUolmkm87aGZcRrmrt1cvcIA22NE/hVcVJo2kNqc8m7CwINzNjt6VSnZXY\n" +
                "cl9ETJbJdaZFCu1I0AVnAyS3c/hTY9Kd4yySF3DDDluDXQR20aFrSLasUnzx+vuP0rPtY3EmQrgg\n" +
                "MGAHG0f1rD27d7HT7JR3Rky6c8ZI2l5mJCpnr70+3tljXbsYyg5Zs4H0rV03TJbyO4upFePcD+8Y\n" +
                "YZfQLV4wx2dukcSZkXDEyHOTjvQ67WlxRpRb0ObltlIIYBDzk9wfQ037KjqFihWUx8qrnofatYW2\n" +
                "5DM9wSzMc7FwCfSrGn6IsjmWcGKAEgYb5mPqapVhOl1KltZQKNrLHufsyZyf8KvaBp1lN4gs4mkd\n" +
                "JlnEgG3lsdj7VHp8csusIyRFoy+3DcbU9fc0v2a60bZeiUrIsjEnHKqOQuaUJ2km2E0nFxW9iT45\n" +
                "akRpiaXG37y9uFiUD0GDWPJBOfDr2lveSWknloqPGcYIxxjv0o8U6rH4v+Inh+1Fu5gihM8ocbfm\n" +
                "Gcn9K1tX0G/jt/Os2M8QySqjJUfTua7cbWvOCi/M83L4KEKkai30OL0TwxaRpcfb4Yry4ZvNkeUZ\n" +
                "wO+PcmtKLQvDzBpBplvsXqdnSrNlZXKqYFV1mvSEG7rjufbFdJa6NClwkKGRtsckTjHDENjdXJWn\n" +
                "KTb5n8melS9lTSjyL7kdN4MjRfDVzIijymkKqAMDjPSvMfDiCAazERjbqUoJ9OlepeH1TTvC9xZF\n" +
                "8m2kZiTxwec15l4KeHVn16/jyIpb2SSPPTtxXRiIJ4CMYs4cPVtmUpSX9aF+S2ScgsqyBRxu6Vn3\n" +
                "01xYwq1qPNw4DoF6AnGRWrOrW1uXfCkjgD1qMrM+3bEJCw+cCvEhGaequj6NuMloys00jWyYG8lt\n" +
                "pX0HrSW08sl3dQkHyoyojc/xZFSCJbS2kMzLHAjdXOD9B61h3upmYubc7Ik6nHJPaumnh3K6aMql\n" +
                "eMbO5f1q0sru2P2kqrR5ZcNhhXEvbJDISsp4+6R1IrYacy5duSe+OCKqy+VIQwRgxJwcda9DDRdG\n" +
                "PK3dHl4q1d8yVmNtdRurCUNFM2zHKsc5rQudXkuAjBtxP3VHOKyo0aViMEDvmrUZjhVljTLnksT2\n" +
                "rSpGm3zW1M6UqiXLfQmOLjIWYLIo+YMcEn2qlKGSQq2d2M4pXEYXcVw3cFsn60+KYiNlncmPH7sA\n" +
                "dP8A61JaK6Km1s9yDy5JVJ5UAcmoHfamRxjj61ZkQy4kHzpnAAPWqx3yO+ANy/kK1i0YuJC5255y\n" +
                "/wDKmIB1PNSiM4JJ3OOp7ConIBArRMzlE627WQXELr8zyFWRCcbF9K6a+KLpcjMjR/KMbT/HWZpZ\n" +
                "tI5WmkYPKyknf0z7VpuYb+wntRzMqbsjsRzXmTd2vI74qyMSFXnT7VcKyIBgZ7+vHepZpVnkQg7Y\n" +
                "0ACxj+taOl6dPdxwvd/fAO1DwMepqzdQWnnRRQwrttxnPq3vUTkrjir6IoafpEl8Q8yFY88Iep9/\n" +
                "pXXWOnpYQCKNAM8nHenafGn2RJDyWJGa0FXfJHhuBxWbvLccpKOiMxraMyq0iAJG2Sf7o70RWizy\n" +
                "yzKcRMM7DwSKuMu+aSMbcDoT2HqaCkYULG5O7kn+9WVmhObKEKuV25+VD0H3RVdiXl8y45UHAQfx\n" +
                "elaErxoxCt8oPGKi2JHI08q7jj5UHYVF7GyfkUmszcOTJkOTnI7D0ragt4jECFCpt2hz0BqpZJJJ\n" +
                "MZX53dE7AVvw22632nAjPJGKqN5GGJq8tkYGlWbQ5nYiSVG27vUHrxU+s2eTCic727ngk+tarwrB\n" +
                "OHQfI3FQXcDSQfLksGyCe1VqtDNVnKopkMOn2Ud4riCNpPJ8tZivzDPYVYCtawKXwHVskZ61G0bC\n" +
                "5QDgKvNaEMEV1GHYZZR61SvLQxm1HV9TJnjs7u8EgCR3ipuBbgEZ/Sn6fbvaa0zFD5RTDbvU9ak1\n" +
                "TSxe25ntRi5RdrAfxJuyce9S2F7j9zOpdBwHxyvsau1mrg581N8uvl2MvxLBd2TX0Vhy93A0KK3Q\n" +
                "k9K5rwroU+j+GLWzniMEuWe5Qj5i5r0S7QHyGO2UxHIbPOO2ay76W1td95O7Fedy+/oPeqnUkoez\n" +
                "W17ioNOUZ21tb1OPuYJ7y8RmH7zfgpjgChtVGkxzJEkc10fu4P3eejf/AFqh1PV5r2NyoW1izwoP\n" +
                "zH3Jrl0M01xJI77c8Bh/H71MI8256M20krblzUri4v5t15KrOBkKn3U9h71msiMq8YiQ5I9fc1Pe\n" +
                "EDESnzJGXqp53ZqGWCWCKO3RiS33unI966YsykkVpGWWQLG48v2P6UJauzGaV8Rg/LGrD9asJFHF\n" +
                "COvlA8sAMsT0xTpgsiKix4B7Z5p8/RA4pIrPLG3KqQDwRimMyheUVT2K1M6iEMxIMh42jriqMrtJ\n" +
                "kbcKOg+tarUwk+UcQpkOclQMkiopHeVxwoX0PcelLKZldi8B2ADC9vxqIMmTkHzB90DpWiVjJu4j\n" +
                "p3ZlCgYyDx9BUscoxsOAoHb7341Dv2lcp8q8n60O8hH7tcKeS3ena5N7CzSIFwCNvfNU5HiDjKFz\n" +
                "j14FT+UrMd0pkz/Cq0ya1bcCkbKuMfMaqLS0M5OTOohLy46FF5Oe/wBKupMQAYmKyYJ4P86pQKjT\n" +
                "gYbIGTzxUyxtExyAY3PykDofevMmtT04TSNixv7wbY5X/ct/F/F9M1oPEYiGSRWxxt9z3rFFrcpG\n" +
                "sj7gA2GXPUeorV8k7BH94r9xs1zzckzWNuh0dhMgtIoldTtAxz1NSyXccDvGzEE4YD+dcjDJDEH2\n" +
                "o8Uu7kE5JNaNnLHISLkEk9Wc8j6UnUYeyTdzSMrahIsMY2R/dZh1Iq/fv9mjSONfnbgfSqdskEUQ\n" +
                "NpICQ275j1qSdppH80q2wABVHJHqaLe6yXZyVtkPtoE3EyY47fzqRonuJGEQCovIPoKriWWbCxAC\n" +
                "MnHTmtKABomCDGDtNEY30RFRuLv1JbFUgk2jGCMnNXbWfeDIGBTOMVip8kjyGUFQNv0qKz1a0ggd\n" +
                "HuUwpzx1qozS0MJ0XNNrU6CMKS8UnBLErSqACYzyw5rl7rxdbhQbeCSWQZx2zVNPGd28gMtpGFxg\n" +
                "AOc1bqQ6krCVXsjsHRFYM3BqRB5BLqw2t29q5OXxZFNF/wAe7+b0CA5yfrTH8T6jHCqT6Z8zDI2t\n" +
                "nA96lTi9hvC1bWZ10cptNRMbNhJlGw9hSzW6FptsYG0kgjjJ9689fxdqEshaQIRGcxptwV4x1q5c\n" +
                "eOboRokcMZJXDFiar2sXoJ4OqrS+83xcxae73skh3EbeejD0xXJazrJ1O8JVSsS5wvRV+vvWfda9\n" +
                "dXvz3EoVFztVVrJNyZeZ5NsYHCL/AB1KTenQ7IU1T977RIyC5kI37gGydp5Y+/tSvBKFPmNHhclc\n" +
                "cYotfs0rB3t3T1dWwB+FTEW077zMCMY2NnBquezsti+XS5lxIEkWaNTLLgrlRwD60bWCOJGDSufm\n" +
                "Zew9KvSuiosaKcZ+6nANPjAZAJIEQD+6eTV+06kcvQoSEvIpO1IlHCY71UlKsPlVwD97J6CrV3Jt\n" +
                "kO1W9ApNVw5UBXcLz0rWLdrmcn0G+T+7yCsYz1c/MaiCRx/Lu3dyelTFkL8pvx3Y/wAqcrQBi/kA\n" +
                "t33nIqlIzauV5EaYgpN8p6g805bMnhIiuepJHNT+cCc7VjUD+FeKiN2xb5Ov96qvLoS0iG4tTtVQ\n" +
                "UVR97Jqr5IVwNwZR90CtRdsieZNCFHZj3/Cq7xmZsW0Tlz0IFOM3sS4rdFSSZkO1AoJ67aYfMY5Y\n" +
                "gfrVv7HcI5Tyfmx8x9KgnidCBsOe9aJozkmdEiRx7XVD5w4bJ6ip7dmT5icxt/Ce1UzcLJGFkwrY\n" +
                "+UjvUol2wJux8uc4rnlE2hI15JgEG2X5Rzg1HbTGWUxNJtx2ArMW7GyNMZYtitKONYrgSZwQOQT1\n" +
                "rCUdDWMizcoiFZFUkpwxPX2qddpUfNuPYVTmuVaBlXcSeM+/bNOsZ12EOMnGD9axlC5vCdkaiTfK\n" +
                "0UvUcrViw1eSDKuw9MEVivOvnouMRNwSTzmrYgEbH5zIg5Vj95frU8rWxTakrM6SO+RlDlAoPcDG\n" +
                "aJNVsbGEO04GTnb3Ncdc69JGpghZS4+8w+b8qxpL0AMJmJZjnn7xNaxUrXMpQhsb2q6419JtjLRw\n" +
                "A5CA43fWs9GHlA8ADqT3qpE4LneVJUcDNSeenzM4BHbnp+FZyg3ubRmoq0SypiAUnjPr2qR5LXHm\n" +
                "LJ0IGBWPJeb3x27Ckll8uMLuAzyRt/rQqFxusjVF8lncGaz/AHZPVm5/IVJBrUtzcvhnmQD7hbbz\n" +
                "7GprbwP4kv8AT47yG0jaOUZXMnzY/KsOWym0iUw3dvNbSKfuMu1m9810ewlCN2c6r05ysmjrvD+h\n" +
                "R+Jr24iaeW1nWLekZG8depNZuqaNq2h3c1vceVI23K7OeO3HvWx8LZll8R3roCNtmfvH/aHWua8a\n" +
                "azcXPxGfTkK7UtlDs5+6Tg5z2rrjhebD8/VHFLGShi/ZbxZTa6lEgDxIzrztaIcH0xUTXN7KoXyo\n" +
                "PLJyVMY4+lXLizntFKNLJcRkbuOVPuD61RuNRnZQG2qo4Ge1cqWuiO2/cuGe2WMi5iVQBkFGwfyq\n" +
                "Ka/02IEJHcGIY+ZU3Ek9utUDCZmGP3jYJJ7gU9raYHaNmByAT0o5Y394OZ9C6VhLlZJ5Y5Cu5Fki\n" +
                "CqB6HmnDT7mUbo5bZRjs2Py9az1tyCf3oZ/4vSpmIEYDjzADna3IqrLoK76kjWVxHnEbbu53ZJ/G\n" +
                "s94mjlO9XT1+WrEjA8LEFP8A0z4qI3c8QKrNKm7j79VFMmTRCJUUksWHvijzw2CB3wMDOfwphu7t\n" +
                "vkSd2PqfmqzBd+RIpuo4JVA5CrtY5rS2hlchVWI+bHzfw058wKpfAGc4q7JBZROfs1zEpf8Ahfhg\n" +
                "TWfPbS4yZ4HOcAGShNsHZIjaZ9wcHI9+1Nsb+eG6lkt5HEZ65bBDf7JpBa3bKSYm2g9uQfxppEoH\n" +
                "zQusY5JArRK2hk3d3Lj6nOzMZCruT8xB2k1Wmu42frMjd+Nw/OqzEyPnlFI7cE1CZdh2xtgD1pxS\n" +
                "Jky8HV1A3cVa+0CWEQNwegIrHtpcKqMQT1qwsvzAr1BpygRGZpwNvmU5wVb+Va8lxuUMfvHmsOFl\n" +
                "+aRTg9xV6K5V4sjGO9YTibwkXBOUcSM2EdSNvqe1Mt74bpSAQWxj2NU57yOKFwX+8MbVGcGqxuU2\n" +
                "rtUjHJLfxVPs9DRVLGwbogOXcrjkDHX2p9xrEMsEcCyFFxzk4Yt6H2rn5rhpyrhSp9OtJG0jfOsS\n" +
                "uw6ljimqK6idZvY0WuSzAJl2Xp+8HNIHQKZTBNG3pjO4/WqhjSMkn5XbgKPT1qtcyzRSKN52+map\n" +
                "QWwOo1qzQe6EgYbJQSclQM/nTttw7NmIk/wgd6pWt05cpJvZP4WxmrRlTylxIdyn7xP3frUyhbQp\n" +
                "TuObbFzIG3g42kYxWhpGnf2zrFvp8KNJJORl+oVe5/KqC3YVDazhZIxj94eoB61614E0GHw/or6w\n" +
                "6H7Rcri3R+qL2FaUKHtJ8pjiMQqVNy6nRazqcWhab5ccvlQ2cO6aQfwqB0HvXz/qnj3WPGWv74UK\n" +
                "6dDkIzDJA9SfU1d+JvieTxHrUfhvTbh22yf6XIpwrt6e4FdO3gX/AIRX4dXAMtst5ceWzPIwComR\n" +
                "yTXq1lePIkeNhvdmqkmXfhUCuq6rJJIWItQrdh1FYieA9a8ReJdW1qNrcWsztBC0kgywU4/Suq8C\n" +
                "29lp3hTWryC4e5cn95Lt2g4TPy57cV5Ha6l4k1SGe9t9blgRrhzG24dMnjArGChCglN6M2nKc8S5\n" +
                "UlqjuLz4da3pluJUiW7UD5vKnBKj/d71iWypFNG0tyFj3fNG33SPpWZL4i8fJCLeDXvMXvIuFP60\n" +
                "21nngQPfGOW7Jy7r/F7n3+lceIp00r05XPRw1arJtVY2NvUtPZJFltIUa3kHTzAMk9hVVrFoz++j\n" +
                "eEr1QdKrxajdBfk2NByfJc4APYj3qRNW05HAe2uFboSG4z+NcnJJrQ6+eN9RsrtENqIA/wBOtQM2\n" +
                "FMhYk+lWy1vOD5F6p5wySfKc/Ws+8jnRCXjKr2P8J+lVGNtxSkmtCV5XT5l2nj16VGsRmXfLMFDe\n" +
                "gpix7cNKGVT2PU043SJERuUvn5fQCnbsRzX3LEdvbqh+bH9aiVU3GOL5FPVs5qmVlmXIyOeppzxB\n" +
                "AFDAMepzzVcvdk819kTvHExL7w74wAexqvKVWPEkQJNKqwR8F2J7il+1woh2oB7nmqSZLa6lVo0T\n" +
                "DJHg/wCyTkVGkt2pzFPITnox4q59oV4t3ABPpVGa4LnCKOK1jcxk0upP9rvlB3NEU6kGmHUYG48p\n" +
                "Se/FVQkjnL5P1pTGrNg4OPSrsjNyZUjIUqSTg1fjnCHaRkkdfSswSApgyIxB4FNad2URKuGY9a3c\n" +
                "DnUzVGoKbhVVNzg8kdDVr7UyFgP4jux2A9KyLZBEDnk96so+6NVYZGeoPSsnBGsZtl7O9g2OPU0o\n" +
                "AGS8ise3tVNptgGHAT3prHMmCeBz0qORmimjVhnhKkKrMcck8VE9wTMNhC7elVhcIEBUD69qiGJB\n" +
                "kA9alQ6luZoi5MjHKh2A5anIsMhVWVwTwD1GfSqeRGAcnLD7gp63yW21pQxU8AIcke9LluPmXUsT\n" +
                "Ext5bNtQHBC/yokaLcEjXcMfdqtKheNZDJuR2wAeGFRs+CVVcNjB+lHKPmO68F+EJ9WuodQv4PK0\n" +
                "mJt7u7ACTHRR7e9d1r+tDUrq58PaVdxpr7WjywQdUiUD7vH8VeG6hrGs3Nhb6Zb6pMlrGApUMVAA\n" +
                "6AYrq/gzpzJ8QZr+SWSaRLVyZJGyTkYyT+Fd+HcIqy3Z5uKjUm+Z7I4rTrRtOeUXcMpv/MLSEEZD\n" +
                "A9Pzr0D4m+NLbV/AWl29o37+72xzRfxR7PUe5FYPi0RW/jvXLeEEqJg4BPTIGah0Lw+/iHXrG0gj\n" +
                "DSiTJbGdq9yfwrP2jhVafU1dONSjFrRI9h8ORWNr8LLC11NmhiuImEsmQpUNkBj+YrzPV/BF/wCD\n" +
                "0SBQ9zp3LQ3afdZTyN3of0rofjZqsVr4dsdFtXXMsixAA4JRepx6ZFZ/g/x0dKaLR9YDXmjSRrG7\n" +
                "THcYj0/Ff1FaVYRcFTbszChOUZyqxV0cs8rRqyBTx2/rVbD9l46kk16L4x8ApaWw1bQYGvrHO5ok\n" +
                "kJZB6jnkVwEE1pK3ltBPHjrk8r9R1rglRlT3R6kK0aqvFkJkkMYRfujqajMgZCuWAX1qzdTWNugR\n" +
                "vPCk5JGOtItpDcYFtdqzEbtkgw1Sl1aKb1siKOTzlK4VUUYJq9pt/Haxm3MbTwNxsc5/Kql1F9mQ\n" +
                "QqhEhGSvt1zUCkx4DDeTz8vai10PmszZcQ3TOLKYOwB/cycMPp2NUMLuJaMlkO3kcZpqRZuEuiG3\n" +
                "qf4eKuakm+b7TESUk5OOmff3qbLoPmvuUHvNrFR85/lVdi+Q2f1p0iKrAkYB/OmSNHnAQkfWtEjN\n" +
                "yfUacqC2ePc1BczGRikeduPvAcVMTlvugLjv3quCclVZQo6g81rFW1MZPoQP500YQMQB2JxTY4Jo\n" +
                "vmSQ7s9D0NTtKQAyovHc/wCFVpJ3lYq0h91UVormLt1LjzED94RnHY1Ued3OV6etQsXAXecAdM0w\n" +
                "TCMnGH+tVGCIdQrbcgbET61ZjyCpJ59u1ZwYjoanSeQY5reSOeMkaiyAcHrU0co2HtWULhsgZH41\n" +
                "Itw2B8wz9KycDaMzSBw2XAxnhaUyIr5PmAd8dqoCUjjAPvUwm3DlsfyqXEvmLS4C7iQUPRh2qXzU\n" +
                "RRtJ59qzxceW4UM2T6dKsG92rhpIzj15xUuDLU0ty15gCNIWOV6kVVWUSHcFOB0FH2gN1A2H8M1K\n" +
                "EjaNVX5OcjPGKSVir32HxXYjQxsBKp529xU8gSS1aSGXdH39RVDymRsMvvuqxZOweQAblZfnNS49\n" +
                "ilPoNjTLH5yWPb+7XsHwfs4otP1vUgyvK+IeP4cf/rrxySXaxReMdT3NdL4M8YP4TvZlkRpbK6X9\n" +
                "+g6qexX3rSn8abMqyvTaRS8TXIn+ImvOuBukVAT0HArttL8YeE/APhub7HcfbNVkGJJEHLtj7q+i\n" +
                "jp+FeU2k7XFxd3TsztPMzEt1xnip5EglJeSBXboGNXKajVbZnGm5UVG4l1qt54n15tZ1UnaOI0Xo\n" +
                "o7AVd3BsEOCSeTjjHtVUzZ42qAOAMVIsny5z8o64FY1ZOcrs6KMFTjyo7rwZ8QZvC8q2l2ZZdKA6\n" +
                "jlofceq+3avRLjw94Q8YxpqkJSOeZMpcWxwpPuo6n614KZAqhzkn+GltLjUdMkM2majNZSvyVjYh\n" +
                "X+q1rTqrl5ahhVotS56WjOo8S+Atc0O4lmkh+0WmPkuoRlVHv3zWAkR8pQVEm0cEHljV0fELx7FA\n" +
                "0K3du6OpDARA5HpWTDe3Ew/eqolf7wQcZrKtBLWD0NqFSctJrU2beRp7eWCcK0mMrnqPbNVDNHCQ\n" +
                "jQFZBxx61VmkMbBFcq3fB4oN+kq7LheV+6wOCKx5L6m/MSvdknO5/QL71XjvpLWR/JYyIeZFc8f/\n" +
                "AK6ka3MhXy5UdD3/AIqiltJIlYhUaMchVGSauMURKTJm23kQnsxuP8UZHP4e1U7lbiP5SqK/YZqW\n" +
                "FXhtoxvKSKNwJHKZ9faphcJco0cgAlUc8559RVKNtiHIyizn95K2T3T2oQqQ21Qvf1pbuEpglz75\n" +
                "9faqvnqj4QcEc5rRK5k3YfJNvTAbFVi5Q9ce9RSSZ5AI+lRM0jYzjA6VrGBjKZOW3csxqNmXsKb5\n" +
                "jhcEZqIlMAgmrsQ5EAapFaqwbmpFatbHOmWUYZz3qVG7A5qojYqQNjkYBqbGikWVkIAxUqygggjr\n" +
                "2qqJB704ODx29ahxNFIuLIMY4I96jeCJ+i7foahBA9/pUnmAe1TZrYq6e5cRhHFiMgv05pwuUiwZ\n" +
                "gQeuR61VD9gRUoYj0P15qHHuWpGhBOroDwUY4J700F7WbK8A9j0YVVjZEzsBGeanWVyvOGQ/wnqK\n" +
                "ho0Uu5YKxSgTKuGbgj0NVJGYEkg4zipvMWEgr0f+H0qRCtwSF4f0PepsVdFIHb8o/HFSGRQF5+Y9\n" +
                "eKbMrKdvQ7uTimqACcoznNVYSdiaN9zEZ/MVYXaBtB46sc1TWRQzKE2nqBmo2kMgAfKf7PrS5bj5\n" +
                "y0D5zbix2DoM9af9p8rhB8/cmqZk6cg46Adqj37m2g4HejluHOaAllmYZfanT607z/JJWI4I6sef\n" +
                "yqiZfl2qTxxS7iU2nk9zS5Q5yXzvMJzkgdKjdtx5HOO/aofNAIA6UNKB8ufm71aiQ5k8bFV2qST3\n" +
                "J71cju5EAVjvHoay0lwwY8L0AqUygAlu3GB3ocQ5i/cSStEpgk2Y+9x1quRGYxsc4XkFuoNVfOdR\n" +
                "u5T0JPWj7YCTnCuf4uoNPlJcyzJcB9sc6gMe/as6Y+TIVccdjSXU7KQuSVbq2OtRBhJGI5CCO1aR\n" +
                "jYyc7kTytnCggVEXkxUjqEOOtRFh2rVJGTbF3kj5v0ppYCmlqjLU7ENkdOBptFWZkgcVIHGOlV6c\n" +
                "G4pWK5iyGBpwYZqsH96eH4pWKUiwH2jrThITxVfeKcGx0qWiuYtBsjB4p6yEcdhVcSe4o3981LiW\n" +
                "pF0SjNOEvQ1T8zH404PzgVLiWpl/7SykMCDz3FSi7YjnHBxwOazPMp4cZznmp5ENTL5lLHKn65pC\n" +
                "o2feJf64xVMSlTx0qQXGDnHNJx7Fc44wt05XvnNNYOrb/mbPX1p32oMPmGPSl35wSaNRXW4jSIFx\n" +
                "yre4JqMNhetOYgjGckGonYrgjr6U7Cch6uSwIOPepGl35UcY6+9U2kGOMhh2oaYKmeRnqafKLnJy\n" +
                "4QnHNRByx54P96ollGMZzTS5LhSOKqxLkWApySzfJ/D9akaUR4LH5sdKqtP2GBUTvuYfNk0ct9xc\n" +
                "6WxJLOZG+ZiR6elRbyB14HrQXA4A/GmEr1Gauxm31JxcADHJGPummvtOGXkdx6VX35ycUb8DrTsJ\n" +
                "yJmlVuDUDHmml800mqSJchS1NzRRTJCiiigAooooAKcDRRQAuacDRRSY0KrcU8MfWiikWhQ5FODs\n" +
                "e9FFIY4OcdKUSMDxRRSHcl3mk3ZPSiipZSYbj9aXe2OtFFIYpkKfMBzimGc+ZgjPvRRTQDGJYnJO\n" +
                "QetGSRjPFFFUjMYyhR60jMRiiimBHn5qdjBz3oopiGsxphbjpRRTJGkk03NFFMkKKKKACiiigD//\n" +
                "2Q==";
        //GenerateImage(strImge, "/Users/zhaohongjie/Downloads/11.jpg");
        // 测试从图片文件转换为Base64编码
        String imgStr = GetImageStr("/Users/zhaohongjie/Downloads/5c819a096a9a8e61.jpg");
        System.out.println(imgStr);
        GenerateImage(strImge, "/Users/zhaohongjie/Downloads/11.jpg");
    }
}
