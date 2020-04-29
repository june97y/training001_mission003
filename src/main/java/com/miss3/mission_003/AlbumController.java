package com.miss3.mission_003;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class AlbumController
{
    //creating an instance of AlbumRepository so that its function can be used
    AlbumRepository albumRepo;

    public AlbumController(AlbumRepository albumRepo)
    {
        this.albumRepo = albumRepo;
    }

    /*create album*/
    @PostMapping("/Album")
    public String create(@RequestBody Album album)
    {
        String temp = "";
        int result = 0;

        try
        {
            result = albumRepo.createAlbum(album);
        }
        catch(Exception e)
        {
            temp = "Error code: " + result + "\nError message: " + e + "\nEnd";
        }

        return temp;
    }

    /*read all album*/
    @GetMapping("/Album")
    @ResponseBody
    public List<Album> readAllAlbum()
    {
        return albumRepo.readAll();
    }

    /*read specific album by id*/
    @GetMapping("/Album/{id}")
    @ResponseBody
    public Album readById(@PathVariable(value = "id") String searchId)
    {
        return albumRepo.readById(searchId);
    }

    /*read specific album by id and title*/
    @GetMapping("/Album/{id}/{title}")
    @ResponseBody
    public List<Album> readByIdAndTitle(@PathVariable(value = "id") String searchId, @PathVariable(value = "title") String title)
    {
        return albumRepo.readByIdAndTitle(searchId, title);
    }

    /*count how many albums in the album table*/
    @GetMapping("/Album/count")
    @ResponseBody
    public int countAlbum() throws Exception
    {
        return albumRepo.countAlbum();
    }

    /*update album*/
    @PutMapping("/Album/{id}")
    @ResponseBody
    public int updateAlbum(@PathVariable(value = "id") String searchId, @RequestBody Album tempAlbum) throws SQLException
    {
        return albumRepo.updateAlbum(searchId, tempAlbum);
    }

    /*delete Album*/
    @DeleteMapping("/Album/{id}")
    @ResponseBody
    public int deleteAlbum(@PathVariable(value = "id") String searchId) throws SQLException
    {
        return albumRepo.deleteAlbum(searchId);
    }
}

