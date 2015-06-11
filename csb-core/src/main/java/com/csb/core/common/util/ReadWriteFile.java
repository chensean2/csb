/*
 * =========================================================================
 *  Program Name: com.saas.common.util.ReadWriteFile
 *
 *  Copyright 2009 saas Pte. Ltd. All Rights Reserved
 *
 *  This software is confidential and proprietary to saas Pte. Ltd. You shall
 *  use this software only in accordance with the terms of the license
 *  agreement you entered into with saas.  No aspect or part or all of this
 *  software may be reproduced, modified or disclosed without full and
 *  direct written authorisation from saas.
 *
 *  saas SUPPLIES THIS SOFTWARE ON AN "AS IS" BASIS. saas MAKES NO
 *  REPRESENTATIONS OR WARRANTIES, EITHER EXPRESSLY OR IMPLIEDLY, ABOUT THE
 *  SUITABILITY OR NON-INFRINGEMENT OF THE SOFTWARE. saas SHALL NOT BE LIABLE
 *  FOR ANY LOSSES OR DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
 *  MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 *
 *  Change Revision
 * -------------------------------------------------------------------------
 *  Version    Remarks
 *  v1.0       - Initial Release
 * =========================================================================
 */
package com.csb.core.common.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ReadWriteFile {
    
    private static int Size_Of_Buffer = 1024;

    public boolean CheckFileExist(String filepath) {
        File file = new File(filepath);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public String ReadStringFromFile(String filepath) {
        File file = new File(filepath);
        if (file.exists()) {
            String line = "";
            String fulltext = "";
            try {
                BufferedReader in = new BufferedReader(new FileReader(filepath));
                while ((line = in.readLine()) != null) {
                    fulltext = fulltext.concat(line);
                    fulltext = fulltext.concat("\n");
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return fulltext;
        } else {
            return "";
        }
    }

    public String[] ReadStringArrayFromFile(String filepath) {
        File file = new File(filepath);
        String[] tempstring = null;
        if (file.exists()) {
            String line = "";
            String fulltext = "";
            try {
                BufferedReader in = new BufferedReader(new FileReader(filepath));
                int i = 0;
                while ((line = in.readLine()) != null) {
                    i++;
                    fulltext = fulltext.concat(line);
                    fulltext = fulltext.concat("\n");
                }
                in.close();

                tempstring = new String[i];
                i = 0;
                in = new BufferedReader(new FileReader(filepath));
                while ((line = in.readLine()) != null) {
                    tempstring[i] = line;
                    i++;
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return tempstring;
        } else {
            return tempstring;
        }
    }

    public void DeleteFile(String filepath) {
        File file = new File(filepath);
        if (file.exists()) {
            file.delete();
        }
    }

    public boolean WriteFileln(String whattowrite, String filepath, boolean append) throws IOException {
        boolean fileok;
        fileok = WriteFile(whattowrite, filepath, append);
        WriteFile("\n", filepath, true);
        return fileok;
    }

    public boolean WriteFile(String whattowrite, String filepath, boolean append) throws IOException {
        boolean filewritesucess = false;
        FileWriter fw = null;
        File file = new File(filepath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file, append);
            fw.append(whattowrite);
            fw.flush();
            filewritesucess = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fw != null) {
                fw.close();
            }
        }
        return filewritesucess;
    }

    public boolean WriteFile(byte[] bytestosave, String filepath) throws IOException {
        boolean filewritesucess = false;
        File file = new File(filepath);
        OutputStream out = new FileOutputStream(file);
        try {
            out.write(bytestosave);
            filewritesucess = true;
        } finally {
            out.close();
        }
        return filewritesucess;
    }

    public boolean WriteFile(Object objectToSave, String filepath) throws IOException {
        boolean filewritesucess = false;
        File file = new File(filepath);
        OutputStream out = new FileOutputStream(file);
        ObjectOutputStream outStream = new ObjectOutputStream(out);

        try {
            outStream.writeObject(objectToSave);
            outStream.flush();
            filewritesucess = true;
        } finally {
            out.close();
        }
        return filewritesucess;
    }

    public byte[] loadFile(String filepath) throws IOException {
        File file = new File(filepath);
        InputStream in = new FileInputStream(file);
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            copy(in, buffer);
            return buffer.toByteArray();
        } finally {
            in.close();
        }
    }

    private void copy(InputStream in, OutputStream out) throws IOException {
        byte[] barr = new byte[Size_Of_Buffer];
        while (true) {
            int r = in.read(barr);
            if (r <= 0) {
                break;
            }
            out.write(barr, 0, r);
        }
    }
}
